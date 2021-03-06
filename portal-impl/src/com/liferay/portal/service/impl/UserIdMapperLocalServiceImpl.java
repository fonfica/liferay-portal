/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.UserIdMapper;
import com.liferay.portal.service.base.UserIdMapperLocalServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class UserIdMapperLocalServiceImpl
	extends UserIdMapperLocalServiceBaseImpl {

	public void deleteUserIdMappers(long userId) throws SystemException {
		userIdMapperPersistence.removeByUserId(userId);
	}

	public UserIdMapper getUserIdMapper(long userId, String type)
		throws PortalException, SystemException {

		return userIdMapperPersistence.findByU_T(userId, type);
	}

	public UserIdMapper getUserIdMapperByExternalUserId(
			String type, String externalUserId)
		throws PortalException, SystemException {

		return userIdMapperPersistence.findByT_E(type, externalUserId);
	}

	public List<UserIdMapper> getUserIdMappers(long userId)
		throws SystemException {

		return userIdMapperPersistence.findByUserId(userId);
	}

	public UserIdMapper updateUserIdMapper(
			long userId, String type, String description, String externalUserId)
		throws SystemException {

		UserIdMapper userIdMapper = userIdMapperPersistence.fetchByU_T(
			userId, type);

		if (userIdMapper == null) {
			long userIdMapperId = counterLocalService.increment();

			userIdMapper = userIdMapperPersistence.create(userIdMapperId);
		}

		userIdMapper.setUserId(userId);
		userIdMapper.setType(type);
		userIdMapper.setDescription(description);
		userIdMapper.setExternalUserId(externalUserId);

		userIdMapperPersistence.update(userIdMapper);

		return userIdMapper;
	}

}