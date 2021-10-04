package com.springbook.view.controller;

// ViewResolver 클래스는 Controller가 리턴한 View 이름에
// 접두사(prefix) 와 접미사(suffix)를 결합하여 
// 최종적으로 실행 될 View 경로와 파일명을 완성한다. 
// ViewResolver도 HandlerMapping과 마찬가지로 
// DispatcherServlet의 init() 메서드가 호출될 때 생성된다.
public class ViewResolver {
	
	public String prefix;
	public String suffix;
	
	// ViewResolver는 setPrefix()와 setSuffix()메서드로 
	// 접두사(prefix) 와 접미사(suffix)를 초기화한다. 
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	// getView() 메서드가 호출될 때 viewName 앞에 prefix를 결합하고 
	// viewName 뒤에 suffix를 결합하여 리턴한다. 
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}

}
