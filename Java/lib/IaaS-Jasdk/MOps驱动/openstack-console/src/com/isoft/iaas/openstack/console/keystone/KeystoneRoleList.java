package com.isoft.iaas.openstack.console.keystone;

import org.apache.commons.cli.CommandLine;

import com.isoft.iaas.openstack.console.utils.Column;
import com.isoft.iaas.openstack.console.utils.Table;
import com.isoft.iaas.openstack.console.utils.TableModel;
import com.isoft.iaas.openstack.keystone.Keystone;
import com.isoft.iaas.openstack.keystone.model.Role;
import com.isoft.iaas.openstack.keystone.model.Roles;

public class KeystoneRoleList extends KeystoneCommand {

	public KeystoneRoleList() {
		super("role-list");
	}

	@Override
	public void execute(Keystone keystone, CommandLine cmd) {

		final Roles roles = keystone.roles().list().execute();

		Table t = new Table(new TableModel<Role>(roles.getList()) {

			@Override
			public Column[] getHeaders() {
				return new Column[] { new Column("id", 32, Column.ALIGN_LEFT),
						new Column("name", 10, Column.ALIGN_LEFT),
						new Column("description", 32, Column.ALIGN_LEFT),
						new Column("enabled", 7, Column.ALIGN_LEFT), };
			}

			@Override
			public String[] getRow(Role role) {
				return new String[] { role.getId(), role.getName(),
						role.getDescription(), role.getEnabled() };
			}
		});
		System.out.println(t.render());
	}

}
