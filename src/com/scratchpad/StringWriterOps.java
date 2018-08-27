/**
 * May 16, 2016sbansal
 */
package com.scratchpad;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sbansal
 */
public class StringWriterOps
{
    public static void main(String[] args)
    {
        //System.out.println(new StringWriter().toString());
        //System.out.println(Math.floor(9/10));
        StringBuilder queryString = new StringBuilder();
        queryString.append(
            "SELECT new com.gartner.ssdtools.erds.entity.SeatholderAggregate(sh.contactSkey, sh.orgCode, sh.intId, sh.jobLevel, sh.jobTitleLst, sh.orgSkey, sh.pkgInqLvl, sh.pkgLobLst, sh.pplCode, sh.personSkey, sh.usrSkey, sh.insertDate, sh.rowId) FROM com.gartner.ssdtools.erds.entity.SeatholderAggregate sh WHERE ( sh.pkgLobLst like('%Market & Competitive Intelligence Standalone%') OR  sh.pkgLobLst like('%Supply Chain Leaders Standalone%') OR  sh.pkgLobLst like('%SCM World Leaders Membership%') OR  sh.pkgLobLst like('%Tech Infra Board%') OR  sh.pkgLobLst like('%Supply Chain Associates%') OR  sh.pkgLobLst like('%Global Chief Architect Research Board%') OR  sh.pkgLobLst like('%Enterprise IT Leaders WG/Team%') OR  sh.pkgLobLst like('%CIO Essentials%') OR  sh.pkgLobLst like('%IT Executive Research Add-on%') OR  sh.pkgLobLst like('%Product Mgmt & Marketing WG%') OR  sh.pkgLobLst like('%Invest%') OR  sh.pkgLobLst like('%Info Risk Mgmt Board%') OR  sh.pkgLobLst like('%General Managers Standalone%') OR  sh.pkgLobLst like('%AMR Peer Forums%') OR  sh.pkgLobLst like('%Industry Advisory Services Standalone%') OR  sh.pkgLobLst like('%IT Leaders Standalone%') OR  sh.pkgLobLst like('%Industry Advisory Services Add-on to EXP%') OR  sh.pkgLobLst like('%CIO%') OR  sh.pkgLobLst like('%IT News & Insight%') OR  sh.pkgLobLst like('%Professional Services%') OR  sh.pkgLobLst like('%Finance Mgmt Board%') OR  sh.pkgLobLst like('%Marketing Providers Standalone%') OR  sh.pkgLobLst like('%Vertical Industry Leader Standalone%') OR  sh.pkgLobLst like('%EUP AMR Classic%') OR  sh.pkgLobLst like('%Chief Supply Chain Officer%') OR  sh.pkgLobLst like('%Vertical Industry Leader WG%') OR  sh.pkgLobLst like('%Emerging Market Technology Prof%') OR  sh.pkgLobLst like('%Research CIO Board%') OR  sh.pkgLobLst like('%Enterprise Supply Chain Leaders WG/Team%') OR  sh.pkgLobLst like('%HTTP IT Professionals%') OR  sh.pkgLobLst like('%Core Connect%') OR  sh.pkgLobLst like('%Analyst Relations WG%') OR  sh.pkgLobLst like('%Dataquest%') OR  sh.pkgLobLst like('%Business Associates%') OR  sh.pkgLobLst like('%CIO Access Reference%') OR  sh.pkgLobLst like('%Enterprise IT Leaders Standalone%') OR  sh.pkgLobLst like('%Media%') OR  sh.pkgLobLst like('%Analyst Relations Standalone%') OR  sh.pkgLobLst like('%HTTP AMR Classic%') OR  sh.pkgLobLst like('%Global IT CFO Research Board%') OR  sh.pkgLobLst like('%Marketing Leaders WG/Team%') OR  sh.pkgLobLst like('%EUP Burton Classic%') OR  sh.pkgLobLst like('%Supply Chain Leaders WG/Team%') OR  sh.pkgLobLst like('%HTTP IDEAS Legacy%') OR  sh.pkgLobLst like('%IT Associates%') OR  sh.pkgLobLst like('%Strategic Sourcing Board%') OR  sh.pkgLobLst like('%Supply Chain Providers WG%') OR  sh.pkgLobLst like('%HP Legacy%') OR  sh.pkgLobLst like('%Marketing Executives Standalone%') OR  sh.pkgLobLst like('%Marketing Providers WG%') OR  sh.pkgLobLst like('%Sales Enablement%') OR  sh.pkgLobLst like('%HTTP Burton Classic%') OR  sh.pkgLobLst like('%Global CISO Research Board%') OR  sh.pkgLobLst like('%SCM World Vendor Membership%') OR  sh.pkgLobLst like('%EXP Leadership Individual%') OR  sh.pkgLobLst like('%Global CIO Research Board%') OR  sh.pkgLobLst like('%Industry Advisory Services WG/Team%') OR  sh.pkgLobLst like('%CIO Signature%') OR  sh.pkgLobLst like('%Market & Competitive Intelligence WG%') OR  sh.pkgLobLst like('%EUP IDEAS Classic%') OR  sh.pkgLobLst like('%SMB CEO Standalone%') OR  sh.pkgLobLst like('%General Managers Team%') OR  sh.pkgLobLst like('%EXP Leadership Team%') OR  sh.pkgLobLst like('%IT Leaders WG/Team%') OR  sh.pkgLobLst like('%Product Mgmt & Marketing Standalone%') OR  sh.pkgLobLst like('%EUP Technology Planner%') OR  sh.pkgLobLst like('%Business Leaders Facilitated Inquiry%') OR  sh.pkgLobLst like('%Supply Chain Providers Standalone%') OR  sh.pkgLobLst like('%Global Head of IT Sourcing Research Board%') OR  sh.pkgLobLst like('%Global Head of I&O Research  Board%') OR  sh.pkgLobLst like('%Core Research%') OR  sh.pkgLobLst like('%EUP Technical Professionals%') OR  sh.pkgLobLst like('%Enterprise Supply Chain Leaders Standalone%') OR  sh.pkgLobLst like('%Research CIO Regional Board%') OR  sh.pkgLobLst like('%Market Visio%') OR  sh.pkgLobLst like('%HTTP Industry Advisory Services%') OR  sh.pkgLobLst like('%On-site Coaching%') OR  sh.pkgLobLst like('%Workforce Mgmt Board%') OR  sh.pkgLobLst like('%CFO%') OR");
        queryString = queryString.replace(queryString.length() - 2, queryString.length(), "");
        queryString.append("SELECT");
        System.out.println(queryString.toString());

        System.out.println("Final ERDS stats: \n" + "1. Total CV/SH/SH-Usages count: \n" + 100);
        String list = "IT Leaders Standalone ~ EUP Burton Classic ~ IT Associates";
        List<String> test = Arrays.asList(list.split("\\s*~\\s*"));
        String list2 = "ITs Leaders Standalone ~ IT Associates";
        List<String> test2 = Arrays.asList(list2.split("\\s*~\\s*"));

        System.out.println(!Collections.disjoint(test, test2));

        System.out.println("ADVSOR ~ (NONE)".contains("ADVISOR"));

    }
}
