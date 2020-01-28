package com.jersey.series.headerparam;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

public interface IBookService {

	public Response getHeaderDetails(String userAgent, String contentType, String accept);
	public Response getAllHeader(HttpHeaders httpHeaders);
}