package com.scratchpad;

import org.apache.commons.lang3.StringUtils;

public class Strings {
	private static String queryForGenerateExcel =
			"select E.AMERICAS_VS_ROW AS \"Americas vs ROW?\", E.SALES_CONTINENT_SVP, E.SALES_GVP, E.SALES_RVP, E.SALES_AVP, E.SALES_AREA_MGR, E.SALES_AE, E.SALES_TEAM_LDR ,"
					+ " E.YEARMO, E.ORG_CODE, E.ORG_NAME, E.SIMPLE_REGION as \"Simple Region\",  E.PRODUCT_GROUP as \"Product Group\", E.PRODUCT_DETAILS as \"Product Details\", E.TRANSACTED_CV,"
					+ " E.MY_FINAL as \"MY Final\", E.ST_CONTRACT as \"Short Term\", E.EP_RISK_FLAG as \"EP Risk\",  E.EV_RISK_FLAG as \"Events Risk\","
					+ " (select RL.USG_ENGMT from CCTLSADM.ERDS_RISK_LOOKUP rl where RL.PRODUCT_GROUP = E.PRODUCT_GROUP and RL.AMERICAS_VS_ROW = E.AMERICAS_VS_ROW  and RL.RISK_GROUP = E.RISK_GROUP ) as \"Usage/Engagement\","
					+ " (select RL.SH_FBK_RKS from CCTLSADM.ERDS_RISK_LOOKUP rl where RL.PRODUCT_GROUP = E.PRODUCT_GROUP and RL.AMERICAS_VS_ROW = E.AMERICAS_VS_ROW  and RL.RISK_GROUP = E.RISK_GROUP ) as \"Client Feedback\","
					+ " E.RISK_GROUP,"
					+ " E.EP_EMP_NM, E.EP_MGR_EMP_NM, E.ECM_EMP_NM, E.ECM_MGR_EMP_NM, E.LCM_EMP_NM, E.LCM_MGR_EMP_NM, E.LP_EMP_NM, E.LP_MGR_EMP_NM, E.TCM_EMP_NM, E.TCM_MGR_EMP_NM,"
					+ " (select max( (select value from CCTLSADM.ENUM_VALUES where enum_id = art.RENEWAL_RESPONSE) )"
					+ "  from CCTLSADM.AA90_ORDERS_INFO art where art.org_cd = E.ORG_CODE and to_char(Art.ORDER_EXP_DT,'YYYYMM') = E.YEARMO ) as \"AA90 Response\","
					+ " (select max(ART.AA90_MEETING_DT) from CCTLSADM.AA90_ORDERS_INFO art where art.org_cd = E.ORG_CODE and to_char(Art.ORDER_EXP_DT,'YYYYMM') = E.YEARMO ) as \"AA90 Touch Point\","
					+ " (select max((select value from CCTLSADM.ENUM_VALUES where enum_id = ART.OBJECTIONS )) from CCTLSADM.AA90_ORDERS_INFO art where art.org_cd = E.ORG_CODE and to_char(Art.ORDER_EXP_DT,'YYYYMM') = E.YEARMO ) as \"AA90 Objections (No/Maybe)\","
					+ "(select max(ART.NOTES)  from CCTLSADM.AA90_ORDERS_INFO art where art.org_cd = E.ORG_CODE and to_char(Art.ORDER_EXP_DT,'YYYYMM') = E.YEARMO ) as \"Next Steps / Comments\""
					+ " from CCTLSADM.ERDS_AGG e where  run_id = 72"
					+ " order by e.YEARMO, E.PRODUCT_GROUP, E.RISK_GROUP";


	public static boolean validate(String fieldName, Object value) {
		return null == value || StringUtils.isBlank(value.toString()) || value.toString().length() <= 10;
	}


	public static void main(String[] args) {
		System.out.println(Strings.validate("sss", "llllllllllllllllllllllllllllllllllll"));

	}
}
