package com.bsoft.anthony.springbootservice.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.*;

public class TransformUtil {

	/**
	 * xml转成map 只解析3层结构
	 * 
	 * @author xuw
	 * @createDate 2019-6-10
	 * @description
	 * @updateInfo
	 * @param xml
	 * @return key
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> xml2map(String xml) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Document doc = DocumentHelper.parseText(xml);
		Element rootElt = doc.getRootElement(); // 获取根节点
		Iterator iter = rootElt.elementIterator();
		while (iter.hasNext()) {
			Element recordEle = (Element) iter.next();
			if (recordEle.isTextOnly()) {
				map.put(recordEle.getName(), recordEle.getText());
			} else {
				Iterator iter_c = recordEle.elementIterator();
				Map<String, Object> map_c = new HashMap<String, Object>();
				while (iter_c.hasNext()) {
					Element recordEle_c = (Element) iter_c.next();
					if (recordEle_c.isTextOnly()) {
						map_c.put(recordEle_c.getName(), recordEle_c.getText());
					} else {
		
					}
				}
				map.put(recordEle.getName(), map_c);
			}
		}
		return map;
	}

	/**
	 * map转成成xml格式的字符串
	 * 
	 * @author xuw
	 * @createDate 2019-6-10
	 * @description
	 * @updateInfo
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String map2xml(Map<String, Object> map) {
		StringBuffer s = new StringBuffer();
		for (String key : map.keySet()) {
			if (map.get(key) != null && map.get(key) instanceof Map) {
				s.append("<").append(key).append(">");
				s.append(map2xml((Map<String, Object>) map.get(key)));
				s.append("</").append(key).append(">");
			} else if (map.get(key) != null && map.get(key) instanceof List) {
				s.append("<").append(key).append(">");
				for (Map<String, Object> m : (List<Map<String, Object>>) map.get(key)) {
					s.append(map2xml(m));
				}
				s.append("</").append(key).append(">");
			} else {
				s.append("<").append(key).append(">");
				s.append(map.get(key));
				s.append("</").append(key).append(">");
			}
		}
		return "<Response>" + s.toString() + "</Response>";
	}

	@SuppressWarnings("unchecked")
	public static String maptoxml_app(Map<String, Object> map) {
		StringBuffer s = new StringBuffer();
		for (String key : map.keySet()) {
			if (map.get(key) != null && map.get(key) instanceof Map) {
				s.append("<").append(key).append(">");
				s.append(mapToxml((Map<String, Object>) map.get(key)));
				s.append("</").append(key).append(">");
			} else if (map.get(key) != null && map.get(key) instanceof List) {
				s.append("<").append(key).append(">");
				for (Map<String, Object> m : (List<Map<String, Object>>) map.get(key)) {
					s.append(mapToxml(m));
				}
				s.append("</").append(key).append(">");
			} else {
				s.append("<").append(key).append(">");
				s.append(map.get(key));
				s.append("</").append(key).append(">");
			}
		}
		return "<Response>" + s.toString() + "</Response>";
	}

	public static String mapToxml(Map<String, Object> map) {
		StringBuffer s = new StringBuffer();
		for (String key : map.keySet()) {
			if (map.get(key) != null && map.get(key) instanceof Map) {
				s.append("<").append(key).append(">");
				s.append(mapToxml((Map<String, Object>) map.get(key)));
				s.append("</").append(key).append(">");
			} else if (map.get(key) != null && map.get(key) instanceof List) {
				s.append("<").append(key).append(">");
				for (Map<String, Object> m : (List<Map<String, Object>>) map.get(key)) {
					s.append(mapToxml(m));
				}
				s.append("</").append(key).append(">");
			} else {
				s.append("<").append(key).append(">");
				s.append(map.get(key));
				s.append("</").append(key).append(">");
			}
		}
		return s.toString();
	}

	public static Map<String, Object> xmlToMap(String xml) throws DocumentException {
		Document doc = DocumentHelper.parseText(xml);
		Map<String, Object> map = new HashMap<String, Object>();
		if (doc == null)
			return map;
		Element rootElement = doc.getRootElement();
		element2map(rootElement, map);
		return map;
	}

	private static void element2map(Element elmt, Map<String, Object> map) {
		if (null == elmt)
			return;
		String name = elmt.getName();
		if (elmt.isTextOnly()) {
			map.put(name, elmt.getText());
		} else {
			Map<String, Object> mapSub = new HashMap<String, Object>();
			List<Element> elements = (List<Element>) elmt.elements();
			for (Element elmtSub : elements) {
				element2map(elmtSub, mapSub);
			}
			Object first = map.get(name);
			if (null == first) {
				map.put(name, mapSub);
			} else {
				if (first instanceof List<?>) {
					((List) first).add(mapSub);
				} else {
					List<Object> listSub = new ArrayList<Object>();
					listSub.add(first);
					listSub.add(mapSub);
					map.put(name, listSub);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// String
		// xml="<transCode>15003</transCode><orgCode>420112005</orgCode><areaCode></areaCode><cardType></cardType><cardNo></cardNo><patientId>3300</patientId><orderNo></orderNo><opType>03</opType><totalAmount>100</totalAmount><payList><payItem><payType>1</payType><payAmt>100</payAmt><tranNo>1</tranNo><payNote>1</payNote><couponIssuer>1</couponIssuer><couponNo>1</couponNo></payItem><payItem><payType>1</payType><payAmt>100</payAmt><tranNo>1</tranNo><payNote>1</payNote><couponIssuer>1</couponIssuer><couponNo>1</couponNo></payItem></payList><presList><preItem><registerNo>1</registerNo><preNo>1</preNo><itemCode>1</itemCode><itemName>1</itemName><PRINT>1</PRINT></preItem><preItem><registerNo>1</registerNo><preNo>1</preNo><itemCode>1</itemCode><itemName>1</itemName><PRINT>1</PRINT></preItem></presList>";
		// String
		// xml2="<transCode>15003</transCode><orgCode>420112005</orgCode><areaCode></areaCode><cardType></cardType><cardNo></cardNo><patientId>3300</patientId><orderNo></orderNo><opType>03</opType><totalAmount>100</totalAmount><payList><payItem><payType>1</payType><payAmt>100</payAmt><tranNo>1</tranNo><payNote>1</payNote><couponIssuer>1</couponIssuer><couponNo>1</couponNo></payItem></payList><presList><preItem><registerNo>1</registerNo><preNo>1</preNo><itemCode>1</itemCode><itemName>1</itemName><PRINT>1</PRINT></preItem></presList>";
		// Map<String,Object> map=TransformUtil.xmlToMap("<xml>"+xml2+"</xml>");
		// Map<String,Object> map2=(Map<String,Object>)map.get("xml");
		// System.out.println(map2);
		String response = "<AuditResultHospital xmlns=\"http://schemas.datacontract.org/2004/07/BMI.Engine.Common.Hospital\" xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\">"
				+ "<ClaimID>50b768e10c02b60f7c9343d9</ClaimID>" + "<Elapsed>0:0:0:324.324563</Elapsed>"
				+ "<Patient_IDStr>0057824702</Patient_IDStr>" + "<ViolationResult>" + "<RuleResultHospital>"
				+ "<DetailID>0</DetailID>" + "<FullTip/>" + "<GroupCode>{30E50964211259DAF0D7832C075574CF}</GroupCode>"
				+ "<ITEM_ID/>" + "<ITEM_NAME/>" + "<Reason>诊断信息不规范</Reason>"
				+ "<Related>50b768e10c02b60f7c9343d9</Related>" + "<ResultType>1</ResultType>"
				+ "<ResultTypeName>非医保支付</ResultTypeName>" + "<RuleName>就诊信息数据异常</RuleName>" + "<RuleNo>150001</RuleNo>"
				+ "<TipsCode4Hospital>N</TipsCode4Hospital>" + "</RuleResultHospital>" + "<RuleResultHospital>"
				+ "<DetailID>70b768e10c02b60f7c934428</DetailID>" + "<FullTip/>"
				+ "<GroupCode>{ABF47EFF6CDEED4FFF8684A5BD7832CA}</GroupCode>" + "<ITEM_ID>x090203004191001</ITEM_ID>"
				+ "<ITEM_NAME>重组人白介素-11[Ⅰ]</ITEM_NAME>" + "<Reason>限放化疗引起的血小板减少患者</Reason>"
				+ "<Related>50b768e10c02b60f7c9343d9|70b768e10c02b60f7c934428</Related>" + "<ResultType>2</ResultType>"
				+ "<ResultTypeName>待核实</ResultTypeName>" + "<RuleName>违反限定适应症(条件)用药</RuleName>"
				+ "<RuleNo>100301</RuleNo>" + "<TipsCode4Hospital>N</TipsCode4Hospital>" + "</RuleResultHospital>"
				+ "<RuleResultHospital>" + "<DetailID>70b768e10c02b60f7c934424</DetailID>" + "<FullTip/>"
				+ "<GroupCode>{D3A8CA51A1DB07AA23EF11D8D6295B40}</GroupCode>" + "<ITEM_ID>f12010001100</ITEM_ID>"
				+ "<ITEM_NAME>吸痰护理</ITEM_NAME>"
				+ "<Reason>重复收费</Reason><Related>50b768e10c02b60f7c9343d9|70b768e10c02b60f7c934422,50b768e10c02b60f7c9343d9|70b768e10c02b60f7c934424</Related>"
				+ "<ResultType>1</ResultType>" + "<ResultTypeName>非医保支付</ResultTypeName>" + "<RuleName>重复收费</RuleName>"
				+ "<RuleNo>130301</RuleNo>"
				+ "<TipsCode4Hospital>130301|{C81E728D9D4C2F636F067F89CC14862C}@0</TipsCode4Hospital>"
				+ "</RuleResultHospital>" + "</ViolationResult>" + "</AuditResultHospital>";
		Map<String, Object> map = TransformUtil.xmlToMap(response);
		System.out.println(map);
	}
}
