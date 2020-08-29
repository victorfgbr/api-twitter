package com.twitter.api.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RulesModel {

	private List<RuleModel> add = new ArrayList<>();

	public RulesModel(String value) {
		super();
		
		RuleModel ruleModel= new RuleModel(value);
		
		add.add(ruleModel);
	}

	public List<RuleModel> getAdd() {
		return add;
	}

	public void setAdd(List<RuleModel> add) {
		this.add = add;
	}
	
	@Override
	public String toString(){
		ObjectMapper Obj = new ObjectMapper(); 
		String jsonStr = null;
		
		try { 
			jsonStr = Obj.writeValueAsString(this); 
		} 

		catch (IOException e) { 
			e.printStackTrace(); 
		}
		
		return jsonStr;				
	}

}
