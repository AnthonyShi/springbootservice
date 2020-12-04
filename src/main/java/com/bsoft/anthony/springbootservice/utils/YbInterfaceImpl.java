// package com.bsoft.anthony.springbootservice.utils;
//
//
// import lombok.extern.slf4j.Slf4j;
// import org.apache.cxf.endpoint.Client;
// import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
//
// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;
//
// @Slf4j
// public class YbInterfaceImpl implements YbInterface {
//     @Override
//     public Map<String, Object> Business_Handle(int OperateType,String inData){
//         Map<String,Object>response = new HashMap<String,Object>();
//         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//         log.info("医保接口开始时间："+sdf.format(new Date())+":业务类型："+OperateType+"，入参："+inData);
//         System.out.println("医保接口开始时间："+sdf.format(new Date())+":业务类型："+OperateType+"，入参："+inData);
//         // 创建动态客户端
//         JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
//         String url = "http://10.90.90.252/SSNC_His_WebService/HisWebService.svc?wsdl";
//         System.out.println(url);
//         Client client = dcf.createClient(url);
//         //测试服务地址：http://10.90.90.51/SSNC_His_WebService/HisWebService.svc?wsdl
//         // 需要密码的情况需要加上用户名和密码
//         // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,PASS_WORD));
//         Object[] objects = new Object[0];
//         try {
//
//             // invoke("方法名",参数1,参数2,参数3....);
// //            int OperateType = 5;
// //            String imput = "450006^2001^00020^110022020155|0012118|^|^";
// //            返回数据:20200615135700-0006-00001^110022020155|0012118|110022|422725195306150027|成海菊||0|13155.72|40817.16|0|1|0|224.80|84.50|0|0|0|0|0|499.42|400|0.85|800|84.50|
//             objects = client.invoke("Business_Handle", OperateType,inData);
//             System.out.println("医保接口结束时间："+sdf.format(new Date())+":业务类型："+OperateType+"返回code:" + objects[0]+"返回数据:" + objects[1]);
//             log.info("医保接口结束时间："+sdf.format(new Date())+":业务类型："+OperateType+"返回code:" + objects[0]+"返回数据:" + objects[1]);
//             response.put("code",objects[0]);
//             response.put("outData",objects[1]);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         return response;
//     }
// }
