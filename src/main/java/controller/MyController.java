package controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import entity.Cat;
import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import serviceimpl.CatServiceImpl;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class MyController {
    @Autowired
    CatServiceImpl csi;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/insert")
    public int insert(){
        Cat cat=new Cat("tom",5,"公");
        return csi.insert(cat);
    }


    @RequestMapping("/provider")
   public Student provider(@RequestParam String name,@RequestParam String time,@RequestParam String secret){
     if(secret.equals("nmsl")){
      Student student=new Student(name,time,secret);
         System.out.println("==============调用者请求已接收");
         System.out.println("name======="+name);
         System.out.println("time======="+time);
         return student;
     }

        return null;
   }


   @RequestMapping("/consumer")
    public String getProvider(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String url="http://122.51.207.132/springboot/provider?name=jyz&time="+sdf.format(date)+"&secret=nmsl";
        ResponseEntity<String> responseEntity=restTemplate.exchange(url, HttpMethod.GET,null,String.class);
       System.out.println("******"+responseEntity);
       if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
           String body=responseEntity.getBody();
           System.out.println("******"+body);
           JSONObject jsonObject = JSON.parseObject(body);//json字符串转json对象
           String name= (String) jsonObject.get("name");//通过json对象的key获取value
           String time= (String) jsonObject.get("time");

           System.out.println("provider回应的数据:");
           System.out.println("---------name:"+name);
           System.out.println("---------time:"+time);

           return body;
       }

           return null;
   }



    @RequestMapping(value="/my",produces = "application/json;charset=utf-8")
    public Cat my(HttpServletResponse res){
        res.setHeader("Access-Control-Allow-Origin", "*");
        return new Cat("zhangshan",20,"男");
}


@RequestMapping(value="/order",produces = "application/json;charset=utf-8")
    public List<JSONObject> orderJson(HttpServletResponse res,String name,String info){
    res.setHeader("Access-Control-Allow-Origin", "*");
    System.out.println("===========name:"+name);
    System.out.println("===========info:"+info);

    Map<String,Object> map1=new HashMap<>();
        map1.put("name","香辣鸡翅");
        map1.put("price","50");

    Map<String,Object> map2=new HashMap<>();
    map2.put("name","全家桶");
    map2.put("price","100");

    Map<String,Object> map3=new HashMap<>();
    map3.put("name","蛋挞");
    map3.put("price","10");
    JSONObject json1 = new JSONObject(map1);
    JSONObject json2 = new JSONObject(map2);
    JSONObject json3 = new JSONObject(map3);
    List<JSONObject> list=new ArrayList<>();
    list.add(json1);
    list.add(json2);
    list.add(json3);
    return list;

}


    @RequestMapping(value="/discuss",produces = "application/json;charset=utf-8")
    public List<JSONObject> discussJson(HttpServletResponse res){
        res.setHeader("Access-Control-Allow-Origin", "*");

        Map<String,Object> map1=new HashMap<>();
        map1.put("name","张三");
        map1.put("msg","很好吃");

        Map<String,Object> map2=new HashMap<>();
        map2.put("name","李四");
        map2.put("msg","黑心商家");

        Map<String,Object> map3=new HashMap<>();
        map3.put("name","王五");
        map3.put("msg","还不错");
        JSONObject json1 = new JSONObject(map1);
        JSONObject json2 = new JSONObject(map2);
        JSONObject json3 = new JSONObject(map3);
        List<JSONObject> list=new ArrayList<>();
        list.add(json1);
        list.add(json2);
        list.add(json3);
        return list;
    }



    @RequestMapping(value="/merchant",produces = "application/json;charset=utf-8")
    public List<JSONObject> merchantJson(HttpServletResponse res){
        res.setHeader("Access-Control-Allow-Origin", "*");

        Map<String,Object> map1=new HashMap<>();
        map1.put("name","汉堡王");
        map1.put("addr","商之都");

        Map<String,Object> map2=new HashMap<>();
        map2.put("name","肯德基");
        map2.put("addr","大东门");

        Map<String,Object> map3=new HashMap<>();
        map3.put("name","海鲜自助");
        map3.put("addr","天鹅湖万达");
        JSONObject json1 = new JSONObject(map1);
        JSONObject json2 = new JSONObject(map2);
        JSONObject json3 = new JSONObject(map3);
        List<JSONObject> list=new ArrayList<>();
        list.add(json1);
        list.add(json2);
        list.add(json3);
        return list;
    }


}
