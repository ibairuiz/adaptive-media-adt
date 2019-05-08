package com.liferay.custom.image.service.contributor;

import com.liferay.custom.image.service.api.CustomImageService;
import com.liferay.portal.kernel.template.TemplateContextContributor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
	immediate = true,
	property = "type=" + TemplateContextContributor.TYPE_GLOBAL,
	service = TemplateContextContributor.class
)
public class CustomImageServiceContextContributor implements TemplateContextContributor {

	@Override
	public void prepare(
		Map<String, Object> contextObjects, HttpServletRequest request) {
		contextObjects.put("customImageService", customImageService);
	}

	@Reference
	private CustomImageService customImageService;

}