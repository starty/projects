dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
    logSql = "true"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            /*
                        dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE"
            */

            dbCreate = "update" // one of 'create', 'create-drop','update'
            //url = "jdbc:hsqldb:mem:devDB"
            driverClassName = "com.mysql.jdbc.Driver"
            username = "root"
            password = "root"
            //url = "jdbc:mysql://localhost/test_modelo_moderations"
            url = "jdbc:mysql://localhost/starty-project"
            cache.provider_class='com.opensymphony.oscache.hibernate.OSCacheProvider'

        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
            dbCreate = "update"

                uri = new URI(System.env.CLEARDB_DATABASE_URL?: "mysql://bb1f66755cc5d5:813d89b1@us-cdbr-east-03.cleardb.com/heroku_26f2c1e58f2831d")
                    //"mysql://99784530f103:934c2a0@server.cleardb.com/heroku_0ac7f6f45fa34")
                url = "jdbc:mysql://"+uri.host+uri.path
                username = uri.userInfo.split(":")[0]
                password = uri.userInfo.split(":")[1]


           /* url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"*/

            }
        }
    }

