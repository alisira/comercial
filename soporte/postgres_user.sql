﻿CREATE ROLE root LOGIN  SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;
alter USER root PASSWORD 'root';