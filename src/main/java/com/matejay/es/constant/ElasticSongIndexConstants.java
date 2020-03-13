package com.matejay.es.constant;

/**
 * es歌词索引字段等变量
 */
public interface ElasticSongIndexConstants {
    // 歌词索引字段
    String FIELD_BP_SONG_ID = "bpSongId";
    String FIELD_LYRIC_TIMESTAMP = "lyricTimestamp";
    String FIELD_LYRIC = "lyric";
    String FIELD_SONG_NAME = "songName";
    String FIELD_ALBUM_NAME = "albumName";
    String FIELD_ARTIST_ID = "artistId";
    String FIELD_ARTIST_NAME = "artistName";
    String FIELD_DURATION = "duration";
    String FIELD_SONG_ID = "songId";
    String FIELD_ALBUM_ID = "albumId";
    String FIELD_PROVIDER_ID = "providerId";

    String HIGHLIGHT_PRE_TAG = "<font color=\"#ED6B87\">";
    String HIGHLIGHT_POST_TAG = "</font>";

    /**
     * 每一句歌词开始时间、结束时间、结束时间类型分隔符
     */
    String LYRIC_TIMESTAMP_SPLIT = "-";

    /**
     * 每一句歌词结束时间类型。 1-准确的歌词结束时间 ；2-开始时间加2秒
     */
    int LYRIC_TIMESTAMP_TYPE_NEXT_START_TIME = 1;
    int LYRIC_TIMESTAMP_TYPE_ADD_2_SECONDS = 2;

    // es库中歌曲id前缀
    String ES_SONG_ID_PRE = "bp-";
}
