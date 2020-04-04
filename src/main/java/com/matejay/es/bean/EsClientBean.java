package com.matejay.es.bean;

import com.matejay.es.constant.PropertyKeyConst;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class EsClientBean {
    private Properties properties;
    private RestHighLevelClient client;
    SearchRequest searchRequest;

    private Logger logger = LoggerFactory.getLogger(EsSongClient.class);

    /**
     * 初始化es client
     */
    public void init() {
        if (this.properties == null) {
            throw new RuntimeException("properties is null");
        } else {
            String hostName = properties.getProperty(PropertyKeyConst.HOST_NAME);
            String port = properties.getProperty(PropertyKeyConst.PORT);
            client = new RestHighLevelClient(RestClient.builder(new HttpHost(hostName, Integer.parseInt(port), "http")));
        }
        logger.info("init es client success");
    }

    public void setIndex(String index) {
        searchRequest = new SearchRequest(index);
    }

    /**
     * 关闭es client
     */
    public void close() {
        if (client != null) {
            try {
                client.close();
                logger.info("close es client success");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public SearchResponse defaultSearch(QueryBuilder query, Integer from, Integer size) throws IOException {
        SearchSourceBuilder searchSource = new SearchSourceBuilder();
        searchSource.query(query);
        searchSource.from(from);
        searchSource.size(size);
        searchSource.sort(new ScoreSortBuilder().order(SortOrder.DESC));
        return search(searchSource);
    }

    public SearchResponse search(SearchSourceBuilder searchSource) throws IOException {
        return search(searchSource, RequestOptions.DEFAULT);
    }

    public SearchResponse search(SearchSourceBuilder searchSource, RequestOptions requestOptions) throws IOException {
        searchRequest.source(searchSource);
        return client.search(searchRequest, requestOptions);
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
