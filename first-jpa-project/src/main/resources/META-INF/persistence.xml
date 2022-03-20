<persistence xmlns="http://java.sun.com/xml/ns/persistence" version="2.0"  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">

<persistence-unit name="atruvia"	transaction-type="RESOURCE_LOCAL">
  <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>

  <shared-cache-mode>DISABLE_SELECTIVE</shared-cache-mode>
  <properties>
    <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect" />
    <property name="hibernate.hbm2ddl.auto" value="update" />
    <property name="hibernate.connection.driver_class" value="org.h2.Driver" />
    <property name="hibernate.connection.username" value="sa" />
    <property name="hibernate.connection.password" value="" />
    <property name="hibernate.connection.url" value="jdbc:h2:c:/tmp/atruvia-jpa;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE" />
    <property name="hibernate.show_sql" value="true" />
    <property name="hibernate.format_sql" value="true" />


    <!-- Important
    <property name="hibernate.connection.provider_class" value="org.hibernate.connection.C3P0ConnectionProvider" />

    <property name="hibernate.c3p0.max_size" value="20" />
    <property name="hibernate.c3p0.min_size" value="5" />
    <property name="hibernate.c3p0.acquire_increment" value="1" />
    <property name="hibernate.c3p0.idle_test_period" value="3000" />
    <property name="hibernate.c3p0.max_statements" value="50" />
    <property name="hibernate.c3p0.timeout" value="300" />
-->

    <!--   property name="hibernate.cache.provider_class" value="net.sf.ehcache.hibernate.SingletonEhCacheRegionFactory"/>
   <property name="hibernate.cache.use_second_level_cache" value="true"/>
<property name="hibernate.cache.use_query_cache" value="true"/>
<property name="hibernate.cache.region.factory_class" value="org.hibernate.cache.ehcache.EhCacheRegionFactory" />
<property name="javax.persistence.sharedCache.mode" value="ALL"/ -->




  </properties>
</persistence-unit>
</persistence>
