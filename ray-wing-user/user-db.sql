

-- ============================================================
-- 多租户 RBAC 权限系统 PostgreSQL 建表脚本
-- ============================================================

-- 1. 租户表
CREATE TABLE sys_tenant (
                            id BIGSERIAL PRIMARY KEY,
                            tenant_code VARCHAR(50) NOT NULL,
                            tenant_name VARCHAR(100) NOT NULL,
                            contact_name VARCHAR(50),
                            contact_phone VARCHAR(20),
                            status SMALLINT DEFAULT 1,
                            expire_time TIMESTAMP WITHOUT TIME ZONE,
                            create_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
                            update_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
                            deleted SMALLINT DEFAULT 0
);

COMMENT ON TABLE sys_tenant IS '租户表';
COMMENT ON COLUMN sys_tenant.id IS '租户ID';
COMMENT ON COLUMN sys_tenant.tenant_code IS '租户编码';
COMMENT ON COLUMN sys_tenant.tenant_name IS '租户名称';
COMMENT ON COLUMN sys_tenant.contact_name IS '联系人';
COMMENT ON COLUMN sys_tenant.contact_phone IS '联系电话';
COMMENT ON COLUMN sys_tenant.status IS '状态：0-禁用 1-启用';
COMMENT ON COLUMN sys_tenant.expire_time IS '过期时间';
COMMENT ON COLUMN sys_tenant.create_time IS '创建时间';
COMMENT ON COLUMN sys_tenant.update_time IS '更新时间';
COMMENT ON COLUMN sys_tenant.deleted IS '删除标记：0-未删除 1-已删除';

-- 唯一约束
ALTER TABLE sys_tenant ADD CONSTRAINT uk_tenant_code UNIQUE (tenant_code);

-- 2. 用户表
CREATE TABLE sys_user (
                          id BIGSERIAL PRIMARY KEY,
                          tenant_id BIGINT NOT NULL,
                          username VARCHAR(50) NOT NULL,
                          password VARCHAR(100) NOT NULL,
                          nickname VARCHAR(50),
                          email VARCHAR(100),
                          phone VARCHAR(20),
                          avatar VARCHAR(255),
                          gender SMALLINT DEFAULT 0,
                          status SMALLINT DEFAULT 1,
                          is_admin SMALLINT DEFAULT 0,
                          last_login_time TIMESTAMP WITHOUT TIME ZONE,
                          last_login_ip VARCHAR(50),
                          create_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
                          update_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
                          deleted SMALLINT DEFAULT 0
);

COMMENT ON TABLE sys_user IS '用户表';
COMMENT ON COLUMN sys_user.id IS '用户ID';
COMMENT ON COLUMN sys_user.tenant_id IS '租户ID';
COMMENT ON COLUMN sys_user.username IS '用户名';
COMMENT ON COLUMN sys_user.password IS '密码（加密存储）';
COMMENT ON COLUMN sys_user.nickname IS '昵称';
COMMENT ON COLUMN sys_user.email IS '邮箱';
COMMENT ON COLUMN sys_user.phone IS '手机号';
COMMENT ON COLUMN sys_user.avatar IS '头像URL';
COMMENT ON COLUMN sys_user.gender IS '性别：0-未知 1-男 2-女';
COMMENT ON COLUMN sys_user.status IS '状态：0-禁用 1-启用';
COMMENT ON COLUMN sys_user.is_admin IS '是否租户管理员：0-否 1-是';
COMMENT ON COLUMN sys_user.last_login_time IS '最后登录时间';
COMMENT ON COLUMN sys_user.last_login_ip IS '最后登录IP';
COMMENT ON COLUMN sys_user.create_time IS '创建时间';
COMMENT ON COLUMN sys_user.update_time IS '更新时间';
COMMENT ON COLUMN sys_user.deleted IS '删除标记';

CREATE UNIQUE INDEX uk_tenant_username ON sys_user (tenant_id, username);

-- 3. 角色表
CREATE TABLE sys_role (
                          id BIGSERIAL PRIMARY KEY,
                          tenant_id BIGINT NOT NULL,
                          role_code VARCHAR(50) NOT NULL,
                          role_name VARCHAR(50) NOT NULL,
                          description VARCHAR(255),
                          sort INT DEFAULT 0,
                          status SMALLINT DEFAULT 1,
                          create_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
                          update_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
                          deleted SMALLINT DEFAULT 0
);

COMMENT ON TABLE sys_role IS '角色表';
COMMENT ON COLUMN sys_role.id IS '角色ID';
COMMENT ON COLUMN sys_role.tenant_id IS '租户ID';
COMMENT ON COLUMN sys_role.role_code IS '角色编码';
COMMENT ON COLUMN sys_role.role_name IS '角色名称';
COMMENT ON COLUMN sys_role.description IS '角色描述';
COMMENT ON COLUMN sys_role.sort IS '排序';
COMMENT ON COLUMN sys_role.status IS '状态：0-禁用 1-启用';
COMMENT ON COLUMN sys_role.create_time IS '创建时间';
COMMENT ON COLUMN sys_role.update_time IS '更新时间';
COMMENT ON COLUMN sys_role.deleted IS '删除标记';

CREATE UNIQUE INDEX uk_tenant_rolecode ON sys_role (tenant_id, role_code);

-- 4. 权限表
CREATE TABLE sys_permission (
                                id BIGSERIAL PRIMARY KEY,
                                tenant_id BIGINT DEFAULT 0,
                                parent_id BIGINT DEFAULT 0,
                                permission_code VARCHAR(100) NOT NULL,
                                permission_name VARCHAR(50) NOT NULL,
                                permission_type SMALLINT NOT NULL,
                                path VARCHAR(255),
                                component VARCHAR(255),
                                icon VARCHAR(50),
                                api_url VARCHAR(255),
                                api_method VARCHAR(10),
                                sort INT DEFAULT 0,
                                visible SMALLINT DEFAULT 1,
                                status SMALLINT DEFAULT 1,
                                create_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
                                update_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
                                deleted SMALLINT DEFAULT 0
);

COMMENT ON TABLE sys_permission IS '权限表';
COMMENT ON COLUMN sys_permission.id IS '权限ID';
COMMENT ON COLUMN sys_permission.tenant_id IS '租户ID（0表示系统内置权限）';
COMMENT ON COLUMN sys_permission.parent_id IS '父权限ID';
COMMENT ON COLUMN sys_permission.permission_code IS '权限编码（如：user:add）';
COMMENT ON COLUMN sys_permission.permission_name IS '权限名称';
COMMENT ON COLUMN sys_permission.permission_type IS '类型：1-菜单 2-按钮 3-接口';
COMMENT ON COLUMN sys_permission.path IS '路由路径（菜单类型）';
COMMENT ON COLUMN sys_permission.component IS '组件路径（菜单类型）';
COMMENT ON COLUMN sys_permission.icon IS '图标';
COMMENT ON COLUMN sys_permission.api_url IS 'API接口地址（接口类型）';
COMMENT ON COLUMN sys_permission.api_method IS 'API请求方法';
COMMENT ON COLUMN sys_permission.sort IS '排序';
COMMENT ON COLUMN sys_permission.visible IS '是否可见';
COMMENT ON COLUMN sys_permission.status IS '状态：0-禁用 1-启用';
COMMENT ON COLUMN sys_permission.create_time IS '创建时间';
COMMENT ON COLUMN sys_permission.update_time IS '更新时间';
COMMENT ON COLUMN sys_permission.deleted IS '删除标记';

CREATE INDEX idx_tenant_parent ON sys_permission (tenant_id, parent_id);

-- 5. 用户角色关联表
CREATE TABLE sys_user_role (
                               id BIGSERIAL PRIMARY KEY,
                               tenant_id BIGINT NOT NULL,
                               user_id BIGINT NOT NULL,
                               role_id BIGINT NOT NULL,
                               create_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

COMMENT ON TABLE sys_user_role IS '用户角色关联表';
COMMENT ON COLUMN sys_user_role.id IS 'ID';
COMMENT ON COLUMN sys_user_role.tenant_id IS '租户ID';
COMMENT ON COLUMN sys_user_role.user_id IS '用户ID';
COMMENT ON COLUMN sys_user_role.role_id IS '角色ID';
COMMENT ON COLUMN sys_user_role.create_time IS '创建时间';

CREATE UNIQUE INDEX uk_user_role ON sys_user_role (tenant_id, user_id, role_id);

-- 6. 角色权限关联表
CREATE TABLE sys_role_permission (
                                     id BIGSERIAL PRIMARY KEY,
                                     tenant_id BIGINT NOT NULL,
                                     role_id BIGINT NOT NULL,
                                     permission_id BIGINT NOT NULL,
                                     create_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

COMMENT ON TABLE sys_role_permission IS '角色权限关联表';
COMMENT ON COLUMN sys_role_permission.id IS 'ID';
COMMENT ON COLUMN sys_role_permission.tenant_id IS '租户ID';
COMMENT ON COLUMN sys_role_permission.role_id IS '角色ID';
COMMENT ON COLUMN sys_role_permission.permission_id IS '权限ID';
COMMENT ON COLUMN sys_role_permission.create_time IS '创建时间';

CREATE UNIQUE INDEX uk_role_permission ON sys_role_permission (tenant_id, role_id, permission_id);

-- 7. 部门表
CREATE TABLE sys_dept (
                          id BIGSERIAL PRIMARY KEY,
                          tenant_id BIGINT NOT NULL,
                          parent_id BIGINT DEFAULT 0,
                          dept_name VARCHAR(50) NOT NULL,
                          dept_code VARCHAR(50),
                          leader VARCHAR(50),
                          phone VARCHAR(20),
                          sort INT DEFAULT 0,
                          status SMALLINT DEFAULT 1,
                          create_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
                          update_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
                          deleted SMALLINT DEFAULT 0
);

COMMENT ON TABLE sys_dept IS '部门表';
COMMENT ON COLUMN sys_dept.id IS '部门ID';
COMMENT ON COLUMN sys_dept.tenant_id IS '租户ID';
COMMENT ON COLUMN sys_dept.parent_id IS '父部门ID';
COMMENT ON COLUMN sys_dept.dept_name IS '部门名称';
COMMENT ON COLUMN sys_dept.dept_code IS '部门编码';
COMMENT ON COLUMN sys_dept.leader IS '负责人';
COMMENT ON COLUMN sys_dept.phone IS '联系电话';
COMMENT ON COLUMN sys_dept.sort IS '排序';
COMMENT ON COLUMN sys_dept.status IS '状态：0-禁用 1-启用';
COMMENT ON COLUMN sys_dept.create_time IS '创建时间';
COMMENT ON COLUMN sys_dept.update_time IS '更新时间';
COMMENT ON COLUMN sys_dept.deleted IS '删除标记';

-- 8. 操作日志表
CREATE TABLE sys_operation_log (
                                   id BIGSERIAL PRIMARY KEY,
                                   tenant_id BIGINT NOT NULL,
                                   user_id BIGINT,
                                   username VARCHAR(50),
                                   operation VARCHAR(50),
                                   method VARCHAR(255),
                                   params TEXT,
                                   ip VARCHAR(50),
                                   status SMALLINT,
                                   error_msg TEXT,
                                   duration BIGINT,
                                   create_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

COMMENT ON TABLE sys_operation_log IS '操作日志表';
COMMENT ON COLUMN sys_operation_log.id IS '日志ID';
COMMENT ON COLUMN sys_operation_log.tenant_id IS '租户ID';
COMMENT ON COLUMN sys_operation_log.user_id IS '操作用户ID';
COMMENT ON COLUMN sys_operation_log.username IS '操作用户名';
COMMENT ON COLUMN sys_operation_log.operation IS '操作描述';
COMMENT ON COLUMN sys_operation_log.method IS '请求方法';
COMMENT ON COLUMN sys_operation_log.params IS '请求参数';
COMMENT ON COLUMN sys_operation_log.ip IS 'IP地址';
COMMENT ON COLUMN sys_operation_log.status IS '操作状态：0-失败 1-成功';
COMMENT ON COLUMN sys_operation_log.error_msg IS '错误信息';
COMMENT ON COLUMN sys_operation_log.duration IS '执行时长(ms)';
COMMENT ON COLUMN sys_operation_log.create_time IS '创建时间';

-- ============================================================
-- 数据权限扩展表
-- ============================================================

-- 9. 角色数据权限表
CREATE TABLE sys_role_data_scope (
                                     id BIGSERIAL PRIMARY KEY,
                                     tenant_id BIGINT NOT NULL,
                                     role_id BIGINT NOT NULL,
                                     data_scope SMALLINT NOT NULL DEFAULT 1,
                                     create_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
                                     update_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

COMMENT ON TABLE sys_role_data_scope IS '角色数据权限表';
COMMENT ON COLUMN sys_role_data_scope.id IS 'ID';
COMMENT ON COLUMN sys_role_data_scope.tenant_id IS '租户ID';
COMMENT ON COLUMN sys_role_data_scope.role_id IS '角色ID';
COMMENT ON COLUMN sys_role_data_scope.data_scope IS '数据范围：1-全部 2-本部门 3-本部门及子部门 4-仅本人 5-自定义';
COMMENT ON COLUMN sys_role_data_scope.create_time IS '创建时间';
COMMENT ON COLUMN sys_role_data_scope.update_time IS '更新时间';

CREATE UNIQUE INDEX uk_role_datascope ON sys_role_data_scope (tenant_id, role_id);

-- 10. 角色数据权限明细表
CREATE TABLE sys_role_data_scope_detail (
                                            id BIGSERIAL PRIMARY KEY,
                                            tenant_id BIGINT NOT NULL,
                                            role_data_scope_id BIGINT NOT NULL,
                                            dept_id BIGINT NOT NULL,
                                            create_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

COMMENT ON TABLE sys_role_data_scope_detail IS '角色数据权限明细表';
COMMENT ON COLUMN sys_role_data_scope_detail.id IS 'ID';
COMMENT ON COLUMN sys_role_data_scope_detail.tenant_id IS '租户ID';
COMMENT ON COLUMN sys_role_data_scope_detail.role_data_scope_id IS '角色数据权限ID';
COMMENT ON COLUMN sys_role_data_scope_detail.dept_id IS '部门ID（自定义范围时使用）';
COMMENT ON COLUMN sys_role_data_scope_detail.create_time IS '创建时间';

CREATE UNIQUE INDEX uk_scope_dept ON sys_role_data_scope_detail (tenant_id, role_data_scope_id, dept_id);