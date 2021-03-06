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

package com.liferay.portlet.social.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link SocialRequestService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SocialRequestService
 * @generated
 */
public class SocialRequestServiceWrapper implements SocialRequestService,
	ServiceWrapper<SocialRequestService> {
	public SocialRequestServiceWrapper(
		SocialRequestService socialRequestService) {
		_socialRequestService = socialRequestService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _socialRequestService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_socialRequestService.setBeanIdentifier(beanIdentifier);
	}

	public com.liferay.portlet.social.model.SocialRequest updateRequest(
		long requestId, int status,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialRequestService.updateRequest(requestId, status,
			themeDisplay);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public SocialRequestService getWrappedSocialRequestService() {
		return _socialRequestService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedSocialRequestService(
		SocialRequestService socialRequestService) {
		_socialRequestService = socialRequestService;
	}

	public SocialRequestService getWrappedService() {
		return _socialRequestService;
	}

	public void setWrappedService(SocialRequestService socialRequestService) {
		_socialRequestService = socialRequestService;
	}

	private SocialRequestService _socialRequestService;
}