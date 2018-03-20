package Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class TestNullList {

	public static void main(String[] args) {
		ERDSAggregate erdsAggregateEntity = new ERDSAggregate();
		Map<Long, String> empMap = new HashMap<>();
		empMap.put(123L, "A");
		empMap.put(12L, "B");
		empMap.put(1L, "C");
		erdsAggregateEntity = transformToEntity(erdsAggregateEntity, "null~11~1", empMap);
		System.out.println(erdsAggregateEntity.getEcmEmpName());
	}

	/**
	 * Method that maps Service Team codes to Service Team Names.
	 * 
	 * @param erdsAggregateEntity
	 * @param cvAggregate
	 * @param empMap
	 * @return
	 */
	public static ERDSAggregate transformToEntity(ERDSAggregate erdsAggregateEntity, String tildeSeperatedString,
			Map<Long, String> empMap) {
		StringBuilder ecmName = new StringBuilder();
		if(StringUtils.isNotBlank(tildeSeperatedString)) {
			for (String ecmCd : Arrays.asList(tildeSeperatedString.split("\\s*~\\s*"))) {
				if(empMap.containsKey(Long.valueOf(ecmCd))){
					ecmName.append(empMap.get(Long.valueOf(ecmCd)) + "(ECM) ~ ");
				}
			}
		}
		erdsAggregateEntity.setEcmEmpName(ecmName.toString().replaceAll(" ~ $", ""));
		return erdsAggregateEntity;
	}
}

class ERDSAggregate {
	String ecmEmpName;

	/**
	 * @return the ecmEmpName
	 */
	public String getEcmEmpName() {
		return ecmEmpName;
	}

	/**
	 * @param ecmEmpName
	 *            the ecmEmpName to set
	 */
	public void setEcmEmpName(String ecmEmpName) {
		this.ecmEmpName = ecmEmpName;
	}

}