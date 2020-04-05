package com.matejay.es.song;

import com.matejay.es.bean.EsClientBean;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * 进行搜索
 */
@Component
public class SongSearch {

    @Autowired
    @Qualifier("songClient")
    private EsClientBean esSongClient;


    public void search() throws IOException {
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("FIELD", "VALUE");
        esSongClient.defaultSearch(matchQueryBuilder, 0, 20);
    }
}
