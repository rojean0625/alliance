package ${ package };

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import com.excellence.common.base.BaseObject;



public class ${ className } extends BaseObject {

	private static final long serialVersionUID = 1L;

	<#list properties as pro>
    	private  ${pro.proType} ${pro.proName};
	</#list>

	public ${ className }(){};

	public ${ className } (<#list properties as pro>${pro.proType} ${pro.proName}<#if pro_has_next>,<#else></#if></#list>){

	<#list properties as pro>
		this.${pro.proName} = ${pro.proName};
	</#list>
	}

	public ${ className }(Map data){

	<#list properties as pro>
		this.${pro.proName} = data.get("${pro.fieldName}") == null ? null : (${pro.proType})data.get("${pro.fieldName}");
	</#list>
	}

	public BaseObject setMap(Map data) {
	<#list properties as pro>
		this.set${pro.proName?cap_first}(data.get("${pro.fieldName}") == null ? null : (${pro.proType})data.get("${pro.fieldName}"));
	</#list>
		return this;
	}

	public Map toMap()
	{
		Map map = new HashMap();
	<#list properties as pro>
		map.put("${pro.fieldName}",${pro.proName});
	</#list>
		return map;
	}

	public String toString(){
		return toMap().toString();
	}

	<#list properties as pro>
	public ${pro.proType} get${pro.proName?cap_first}() {
		return this.${pro.proName};
	}
	public void set${pro.proName?cap_first}(Integer ${pro.proName}) {
		this.${pro.proName} = ${pro.proName};
	}
	</#list>

}