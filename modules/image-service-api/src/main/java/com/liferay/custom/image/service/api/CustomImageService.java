package com.liferay.custom.image.service.api;

import com.liferay.portal.kernel.repository.model.FileVersion;

/**
 * CustomImageService API
 * @author ibairuiz
 */
public interface CustomImageService {
    public FileVersion getFileVersionFromFileEntry(long fileEntryId);
}