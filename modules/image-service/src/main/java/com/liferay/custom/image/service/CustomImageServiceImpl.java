package com.liferay.custom.image.service;

import com.liferay.custom.image.service.api.CustomImageService;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileVersion;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * CustomImageService Implementation
  * The idea is to hide "business logic" in an OSGi service that
 * can be injected into the Freemarker Context via a Context Contributor.
 * @author ibairuiz
 */
@Component(
	immediate = true,
	service = CustomImageService.class
)
public class CustomImageServiceImpl implements CustomImageService {

	@Override
	public FileVersion getFileVersionFromFileEntry(long fileEntryId) {
		FileVersion fileVersion = null;
		try {
			DLFileEntry imageFileEntry = dlFileEntryLocalService.getFileEntry(fileEntryId);
			long imageFileVersionId = imageFileEntry.getFileVersion().getFileVersionId();
			fileVersion = dlAppLocalService.getFileVersion(imageFileVersionId);
		} catch (PortalException e) {
			if (logger.isErrorEnabled()) {
				logger.error(e);
			}			
		}

		return fileVersion;
	}

	@Reference
	private DLFileEntryLocalService dlFileEntryLocalService;

	@Reference
	private DLAppLocalService dlAppLocalService;

	private Log logger = LogFactoryUtil.getLog(CustomImageServiceImpl.class);

}