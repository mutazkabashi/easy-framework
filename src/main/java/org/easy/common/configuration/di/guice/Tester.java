package org.easy.common.configuration.di.guice;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.easy.common.persistence.pojo.CorePojo;
import org.easy.common.utils.Util;

public class Tester {
	
	//@Inject
	public Tester(/*@Named("bankPojo") CorePojo cp*/){
		CorePojo cp = null ;
		//System.out.println("Core Pojo Type === "+test(cp));
	}
	
	@Inject
	public void test(@Named("bankPojo") CorePojo cp){
		System.out.println("test ()Core Pojo Type === "+Util.getClassName(cp));
	}

}
