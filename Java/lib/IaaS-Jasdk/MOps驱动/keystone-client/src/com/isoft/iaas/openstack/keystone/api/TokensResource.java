package com.isoft.iaas.openstack.keystone.api;

import com.isoft.iaas.openstack.base.client.Entity;
import com.isoft.iaas.openstack.base.client.HttpMethod;
import com.isoft.iaas.openstack.base.client.OpenStackClient;
import com.isoft.iaas.openstack.base.client.OpenStackRequest;
import com.isoft.iaas.openstack.keystone.model.Access;
import com.isoft.iaas.openstack.keystone.model.Authentication;
import com.isoft.iaas.openstack.keystone.model.authentication.AccessKey;
import com.isoft.iaas.openstack.keystone.model.authentication.TokenAuthentication;
import com.isoft.iaas.openstack.keystone.model.authentication.UsernamePassword;

public class TokensResource {

	private final OpenStackClient CLIENT;

	public TokensResource(OpenStackClient client) {
		CLIENT = client;
	}

	public Authenticate.Builder authenticate() {
		return new Authenticate().new Builder();
	}

	public Authenticate authenticate(Authentication authentication) {
		return new Authenticate(authentication);
	}

	public class Authenticate extends OpenStackRequest<Access> {

		private Authentication authentication;

		public Authenticate() {

		}

		public Authenticate(Authentication authentication) {
			super(CLIENT, HttpMethod.POST, "/tokens", Entity
					.json(authentication), Access.class);
			this.authentication = authentication;
		}

		public Authenticate withTenantId(String tenantId) {
			authentication.setTenantId(tenantId);
			return this;
		}

		public Authenticate withTenantName(String tenantName) {
			authentication.setTenantName(tenantName);
			return this;
		}

		public class Builder {

			public Authenticate withUsernamePassword(String username,
					String password) {
				Authentication authentication = new UsernamePassword(username,
						password);
				return new Authenticate(authentication);
			}

			public Authenticate withToken(String token) {
				Authentication authentication = new TokenAuthentication(token);
				return new Authenticate(authentication);
			}

			public Authenticate withAccessKey(String accessKey, String secretKey) {
				Authentication authentication = new AccessKey(accessKey,
						secretKey);
				return new Authenticate(authentication);
			}

		}

	}

}
