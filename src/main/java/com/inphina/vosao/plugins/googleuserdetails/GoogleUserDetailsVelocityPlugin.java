/**
 * Plugin for Accessing Back-End Google User Service in Vosao CMS
 *
 * Copyright (C) 2010-2011 Inphina Technologies Pvt. Ltd.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * email: info@inphina.com
 */

package com.inphina.vosao.plugins.googleuserdetails;

import com.google.appengine.api.users.UserServiceFactory;
import org.vosao.business.Business;
import org.vosao.velocity.plugin.AbstractVelocityPlugin;

public class GoogleUserDetailsVelocityPlugin extends AbstractVelocityPlugin {

  public GoogleUserDetailsVelocityPlugin(Business aBusiness) {
    setBusiness(aBusiness);
  }

  public String render() {
    return getEmail();
  }

  public String getEmail() {
    try {
      return UserServiceFactory.getUserService().getCurrentUser().getEmail();
    } catch (Exception exception) {
      return "";
    }
  }

  public String getNickname() {
    try {
      return UserServiceFactory.getUserService().getCurrentUser().getNickname();
    } catch (Exception exception) {
      return "";
    }
  }

  public String getUserId() {
    try {
      return UserServiceFactory.getUserService().getCurrentUser().getUserId();
    } catch (Exception exception) {
      return "";
    }
  }

  public String getLogoutUrl() {
    try {
      return UserServiceFactory.getUserService().createLogoutURL("/");
    } catch (Exception exception) {
      return "";
    }
  }
}
