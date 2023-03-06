package com.mkx.soa.service.impl;

import com.alibaba.fastjson.JSON;
import com.mkx.soa.dao.ServiceDao;
import com.mkx.soa.dao.ServiceProviderDao;
import com.mkx.soa.entity.Service;
import com.mkx.soa.entity.ServiceProvider;
import com.mkx.soa.entityPlus.ServiceDetailedInfo;
import com.mkx.soa.service.ElasticSearchService;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class ElasticSearchServiceImpl implements ElasticSearchService {
    @Autowired
    private ServiceDao serviceDao;
    @Autowired
    private ServiceProviderDao serviceProviderDao;
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public void initEs() throws IOException {
        //----------------创建索引（service）------------------
        //创建索引请求
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("service");
        //客户端执行请求，请求后获得响应
        CreateIndexResponse createIndexResponse =
                restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
    }

    @Override
    public void addDataToEs() throws IOException {
        //------------------------从数据库中获得服务的信息--------------------
        List<ServiceDetailedInfo> serviceDetailedInfoList = new ArrayList<ServiceDetailedInfo>();
        List<Service> serviceList = serviceDao.queryService();
        for (int i = 0; i < serviceList.size(); i++) {
            Service service = serviceList.get(i);
            ServiceProvider serviceProvider = serviceProviderDao.getServiceProviderById(service.getProviderId());
            ServiceDetailedInfo serviceDetailedInfo = new ServiceDetailedInfo(service.getId(),
                    service.getName(),service.getProviderId(),service.getWsdl(),service.getPictureUrl(),
                    serviceProvider.getName(),serviceProvider.getLocation(),
                    serviceProvider.getBriefInfo(),serviceProvider.getUrl());
            serviceDetailedInfoList.add(serviceDetailedInfo);
        }

        //----------------------将数据库信息复制到Es索引中---------------------
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("2m");
        for (int i = 0; i < serviceDetailedInfoList.size(); i++) {
            bulkRequest.add(
                    new IndexRequest("service")
                            .id(""+(i+1))
                            .source(JSON.toJSONString(serviceDetailedInfoList.get(i)), XContentType.JSON)
            );
        }
        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest,RequestOptions.DEFAULT);
    }

    @Override
    public void deleteDataInEs() throws IOException {
        //----------------删除索引（service）------------------
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("service");
        AcknowledgedResponse delete =
                restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);

        //----------------创建索引（service）------------------
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("service");
        CreateIndexResponse createIndexResponse =
                restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
    }

    @Override
    public List<Map<String, Object>> getDataInEs() throws IOException {
        SearchRequest searchRequest = new SearchRequest("service");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("_type","_doc");
        searchSourceBuilder.query(matchQueryBuilder);
        searchSourceBuilder.timeout(TimeValue.MINUS_ONE);

        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);

        ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for (SearchHit documentFields:searchResponse.getHits().getHits()) {
            list.add(documentFields.getSourceAsMap());
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getServicesByKeyWord(String keyWord) throws IOException {
        SearchRequest searchRequest = new SearchRequest("service");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("name",keyWord);
        searchSourceBuilder.query(matchQueryBuilder);
        searchSourceBuilder.timeout(TimeValue.MINUS_ONE);

        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);

        ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for (SearchHit documentFields:searchResponse.getHits().getHits()) {
            list.add(documentFields.getSourceAsMap());
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getServicesByKeyWord1(String keyWord) throws IOException {
        SearchRequest searchRequest = new SearchRequest("service");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("name",keyWord);
        searchSourceBuilder.query(termQueryBuilder);
        searchSourceBuilder.timeout(TimeValue.MINUS_ONE);

        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);

        ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for (SearchHit documentFields:searchResponse.getHits().getHits()) {
            list.add(documentFields.getSourceAsMap());
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getServicesByAttributeAndKeyWord(String attribute, String keyWord) throws IOException {
        SearchRequest searchRequest = new SearchRequest("service");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder(attribute,keyWord);
        searchSourceBuilder.query(matchQueryBuilder);
        searchSourceBuilder.timeout(TimeValue.MINUS_ONE);

        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);

        ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for (SearchHit documentFields:searchResponse.getHits().getHits()) {
            list.add(documentFields.getSourceAsMap());
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getServicesByAttributeAndKeyWord1(String attribute, String keyWord) throws IOException {
        SearchRequest searchRequest = new SearchRequest("service");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        TermQueryBuilder termQueryBuilder = new TermQueryBuilder(attribute,keyWord);
        searchSourceBuilder.query(termQueryBuilder);
        searchSourceBuilder.timeout(TimeValue.MINUS_ONE);

        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);

        ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for (SearchHit documentFields:searchResponse.getHits().getHits()) {
            list.add(documentFields.getSourceAsMap());
        }
        return list;
    }

}
