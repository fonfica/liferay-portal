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

package com.liferay.portalweb.portal.tags.blogs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertDeletedTagDoesNotPersistTest extends BaseTestCase {
	public void testAssertDeletedTagDoesNotPersist() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Blogs Tags Test Page");
		selenium.clickAt("link=Blogs Tags Test Page",
			RuntimeVariables.replace("Blogs Tags Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Tags Blog Entry1 Title"),
			selenium.getText("xPath=(//div[@class='entry-title']/h2/a)[3]"));
		selenium.clickAt("xPath=(//div[@class='entry-title']/h2/a)[3]",
			RuntimeVariables.replace("Tags Blog Entry1 Title"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("selenium2 liferay2"));
		selenium.waitForVisible("link=Blogs Tags Test Page");
		selenium.clickAt("link=Blogs Tags Test Page",
			RuntimeVariables.replace("Blogs Tags Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("xPath=(//div[@class='entry-title']/h2/a)[2]",
			"Tags Blog Entry2 Title");
		assertEquals(RuntimeVariables.replace("Tags Blog Entry2 Title"),
			selenium.getText("xPath=(//div[@class='entry-title']/h2/a)[2]"));
		selenium.clickAt("xPath=(//div[@class='entry-title']/h2/a)[2]",
			RuntimeVariables.replace("Tags Blog Entry2 Title"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("selenium2 liferay2"));
		selenium.waitForVisible("link=Blogs Tags Test Page");
		selenium.clickAt("link=Blogs Tags Test Page",
			RuntimeVariables.replace("Blogs Tags Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("xPath=(//div[@class='entry-title']/h2/a)[1]",
			"Tags Blog Entry3 Title");
		assertEquals(RuntimeVariables.replace("Tags Blog Entry3 Title"),
			selenium.getText("xPath=(//div[@class='entry-title']/h2/a)[1]"));
		selenium.clickAt("xPath=(//div[@class='entry-title']/h2/a)[1]",
			RuntimeVariables.replace("Tags Blog Entry3 Title"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("selenium2 liferay2"));
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Blogs Tags Test Page");
		selenium.clickAt("link=Blogs Tags Test Page",
			RuntimeVariables.replace("Blogs Tags Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_33_keywords']",
			RuntimeVariables.replace("\"selenium2 liferay2\""));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"No entries were found that matched the keywords: \"selenium2 liferay2\"."),
			selenium.getText("//div[@class='portlet-msg-info']"));
	}
}