package com.xuecheng.search.config;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSearch {

    @Autowired
    RestHighLevelClient client;

    @Autowired
    RestClient restClient;

    //搜索type下的全部记录
    @Test
    public void testSearchAll() throws IOException, ParseException {
        //搜索请求对象
        SearchRequest searchRequest = new SearchRequest("xc_course");

        //设置类型
        searchRequest.types("doc");
        //搜索源构建对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //设置分页参数
//当前页码
  /*      int page = 2;//页码
        int size = 1;//每页显示个数
        int from = (page - 1) * size;//起记录下标
        searchSourceBuilder.from(from);
        searchSourceBuilder.size(size);*/
        //搜索全部
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        //TermQuery
//        searchSourceBuilder.query(QueryBuilders.termQuery("name","spring"));
        //主键
        String[] ids = new String[]{"1", "2"};
//TermQuery
        searchSourceBuilder.query(QueryBuilders.termsQuery("_id", ids));
        //source源字段过虑
        searchSourceBuilder.fetchSource(new String[]{"name", "studymodel", "price", "timestamp"}, new String[]{});
        //设置搜索源
        searchRequest.source(searchSourceBuilder);
        //执行搜索
        SearchResponse searchResponse = client.search(searchRequest);
        //搜索匹配结果
        SearchHits hits = searchResponse.getHits();
        //搜索总记录数
        long totalHits = hits.totalHits;
        //匹配度较高的前N个文档
        SearchHit[] searchHits = hits.getHits();
        //日期格式化对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (SearchHit hit : searchHits) {
            //文档id
            String id = hit.getId();
            //源文档内容
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            //获取源文档name
            String name = (String) sourceAsMap.get("name");
            String description = (String) sourceAsMap.get("description");
            String studymodel = (String) sourceAsMap.get("studymodel");
            Double price = (Double) sourceAsMap.get("price");
            Date timestamp = dateFormat.parse((String) sourceAsMap.get("timestamp"));
            System.out.println(name);
            System.out.println(studymodel);
            System.out.println(description);
        }


    }

    //根据关键字搜索
    @Test
    public void testMatchQuery() throws IOException, ParseException {
        //搜索请求对象
        SearchRequest searchRequest = new SearchRequest("xc_course");
        //设置类型
        searchRequest.types("doc");
        //搜索源构建对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();



        //MatcherQuery
//        searchSourceBuilder.query(QueryBuilders.matchQuery("description", "spring开发").operator(Operator.OR));
        //MatcherQuery
      /*  searchSourceBuilder.query(QueryBuilders.matchQuery("description","spring开发框架")
                .operator(Operator.OR)
                .minimumShouldMatch("80%"));*/
        //source源字段过虑
//        searchSourceBuilder.fetchSource(new String[]{"name", "studymodel", "price", "timestamp"}, new String[]{});
        //设置搜索源
//        searchRequest.source(searchSourceBuilder);

        //MultiMatcherQuery
        /*MultiMatchQueryBuilder matchQueryBuilder = QueryBuilders.multiMatchQuery("spring css", "name", "description")
                .minimumShouldMatch("50%")
                .field("name", 10);
        searchSourceBuilder.query(matchQueryBuilder);*/

//#########################################################
        //BoolQuery，将搜索关键字分词，拿分词去索引库搜索

//MultiMatcherQuery
        /*MultiMatchQueryBuilder matchQueryBuilder = QueryBuilders.multiMatchQuery("spring css", "name", "description")
                .minimumShouldMatch("50%")
                .field("name", 10);
//TermQuery
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("studymodel", "201001");
//boolQueryBuilder
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//将MultiMatcherQuery和TermQuery组织在一起
        boolQueryBuilder.must(matchQueryBuilder);
        boolQueryBuilder.must(termQueryBuilder);
        searchSourceBuilder.query(boolQueryBuilder);*/
//#####################################
        //MultiMatcherQuery
        MultiMatchQueryBuilder matchQueryBuilder = QueryBuilders.multiMatchQuery("spring css", "name", "description")
                .minimumShouldMatch("50%")
                .field("name", 10);

//boolQueryBuilder
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//将MultiMatcherQuery和TermQuery组织在一起
        boolQueryBuilder.must(matchQueryBuilder);
//添加过虑器
//项过虑
        boolQueryBuilder.filter(QueryBuilders.termQuery("studymodel","201001"));
//范围过虑
        boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(60).lte(100));
        searchSourceBuilder.query(boolQueryBuilder);


        //执行搜索
        SearchResponse searchResponse = client.search(searchRequest);
        //搜索匹配结果
        SearchHits hits = searchResponse.getHits();
        //搜索总记录数
        long totalHits = hits.totalHits;
        //匹配度较高的前N个文档
        SearchHit[] searchHits = hits.getHits();
        //日期格式化对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (SearchHit hit : searchHits) {
            //文档id
            String id = hit.getId();
            //源文档内容
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            //获取源文档name
            String name = (String) sourceAsMap.get("name");
            String description = (String) sourceAsMap.get("description");
            String studymodel = (String) sourceAsMap.get("studymodel");
            Double price = (Double) sourceAsMap.get("price");
            Date timestamp = dateFormat.parse((String) sourceAsMap.get("timestamp"));
            System.out.println(name);
            System.out.println(studymodel);
            System.out.println(description);
        }


    }

    @Test
    public void testSort() throws IOException, ParseException {
        //搜索请求对象
        SearchRequest searchRequest = new SearchRequest("xc_course");
        //设置类型
        searchRequest.types("doc");
        //搜索源构建对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //source源字段过虑
        searchSourceBuilder.fetchSource(new String[]{"name","studymodel","price","timestamp"},new String[]{});
        //boolQueryBuilder
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //添加过虑器
        //范围过虑
        boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(0).lte(100));
        searchSourceBuilder.query(boolQueryBuilder);
        //设置搜索源
        searchRequest.source(searchSourceBuilder);
        //设置排序
        searchSourceBuilder.sort("studymodel", SortOrder.DESC);
        searchSourceBuilder.sort("price", SortOrder.ASC);
        //执行搜索
        SearchResponse searchResponse = client.search(searchRequest);
        //搜索匹配结果
        SearchHits hits = searchResponse.getHits();
        //搜索总记录数
        long totalHits = hits.totalHits;
        //匹配度较高的前N个文档
        SearchHit[] searchHits = hits.getHits();
        //日期格式化对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(SearchHit hit:searchHits){
            //文档id
            String id = hit.getId();
            //源文档内容
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            //获取源文档name
            String name = (String) sourceAsMap.get("name");
            String description = (String) sourceAsMap.get("description");
            String studymodel = (String) sourceAsMap.get("studymodel");
            Double price = (Double) sourceAsMap.get("price");
            Date timestamp = dateFormat.parse((String) sourceAsMap.get("timestamp"));
            System.out.println(name);
            System.out.println(studymodel);
            System.out.println(description);
        }
    }

    @Test
    public void testHighLight() throws IOException, ParseException {
        //搜索请求对象
        SearchRequest searchRequest = new SearchRequest("xc_course");
        //设置类型
        searchRequest.types("doc");
        //搜索源构建对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //source源字段过虑
        searchSourceBuilder.fetchSource(new String[]{"name","studymodel","price","timestamp"},new String[]{});
        //MultiMatcherQuery
        MultiMatchQueryBuilder matchQueryBuilder = QueryBuilders.multiMatchQuery("开发框架", "name", "description")
                .minimumShouldMatch("80%")
                .field("name", 10);
        //boolQueryBuilder
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(matchQueryBuilder);
        //添加过虑器
        //范围过虑
        boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(0).lte(100));
        searchSourceBuilder.query(boolQueryBuilder);
        //设置搜索源
        searchRequest.source(searchSourceBuilder);
        //设置排序
        searchSourceBuilder.sort("studymodel", SortOrder.DESC);
        searchSourceBuilder.sort("price", SortOrder.ASC);
        //设置高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<tag>");
        highlightBuilder.postTags("</tag>");
        highlightBuilder.fields().add(new HighlightBuilder.Field("name"));
        searchSourceBuilder.highlighter(highlightBuilder);
        //执行搜索
        SearchResponse searchResponse = client.search(searchRequest);
        //搜索匹配结果
        SearchHits hits = searchResponse.getHits();
        //搜索总记录数
        long totalHits = hits.totalHits;
        //匹配度较高的前N个文档
        SearchHit[] searchHits = hits.getHits();
        //日期格式化对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(SearchHit hit:searchHits){
            //文档id
            String id = hit.getId();
            //源文档内容
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            //获取源文档name
            String name = (String) sourceAsMap.get("name");
            //取出高亮字段
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            if(highlightFields!=null){
                //取出name高亮字段
                HighlightField nameField = highlightFields.get("name");
                if(nameField!=null){
                    Text[] fragments = nameField.fragments();
                    StringBuffer stringBuffer = new StringBuffer();
                    for(Text text:fragments){
                        stringBuffer.append(text);
                    }
                    name = stringBuffer.toString();
                }

            }


            String description = (String) sourceAsMap.get("description");
            String studymodel = (String) sourceAsMap.get("studymodel");
            Double price = (Double) sourceAsMap.get("price");
            Date timestamp = dateFormat.parse((String) sourceAsMap.get("timestamp"));
            System.out.println(name);
            System.out.println(studymodel);
            System.out.println(description);
        }
    }
}