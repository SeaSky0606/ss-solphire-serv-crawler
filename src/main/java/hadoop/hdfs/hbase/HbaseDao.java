package hadoop.hdfs.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import seasky.solphire.crawler.pojo.TaotaoData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/6.
 */
public class HbaseDao {
    private Configuration conf = HBaseConfiguration.create();
    public HbaseDao(){
        conf.addResource("hdfs-site.xml");
        conf.addResource("core-site.xml");
        conf.addResource("hbase-site.xml");
    }


    /**
     * execute scan operation from hbase for all items
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public Map<String,String> scan() throws Exception{
        HashMap<String,String> map = new HashMap<String,String>();
        HTable table = new HTable(conf, "t1");
        Scan scan = new Scan();
        for (Result result : table.getScanner(scan)) {
            for (KeyValue kv : result.raw()) {
                map.put(new String(kv.getQualifier()),new String(kv.getValue()));
            }
        }
        return map;
    }

    /**
     * insert into hbase
     * @param data
     * @throws Exception
     */
    public void save2Hbase(TaotaoData data) throws Exception{
        HTable table = new HTable(conf,"test");
        Put put = new Put(Bytes.toBytes("baike|9209"));
        put.add("base_info".getBytes(),"area".getBytes(),data.getArea().getBytes());
        put.add("base_info".getBytes(),"onshow".getBytes(),data.getOnshow().getBytes());
        table.put(put);
    }

    public static void  main(String[] args){

    }
}
