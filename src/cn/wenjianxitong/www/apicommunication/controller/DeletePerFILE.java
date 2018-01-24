package cn.wenjianxitong.www.apicommunication.controller;

import cn.wenjianxitong.www.exception.file.MongoDbException;
import cn.wenjianxitong.www.utils.MongoDbPool;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class DeletePerFILE {
    public DeletePerFILE(String fileToken, String privilege_user, String user_id, String check_code) throws MongoDbException{
        try {
            MongoDatabase mongoDatabase = MongoDbPool.getConn("wjxt");
            MongoCollection<Document> collection = mongoDatabase.getCollection("permanentfile");
            //System.out.println("DPF1");
            collection.deleteMany(Filters.eq("file_token", fileToken));
        }catch (Exception e) {
            throw new MongoDbException();
        }

    }
}
