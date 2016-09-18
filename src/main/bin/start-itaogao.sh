#!/bin/sh

nohup sh run.sh itaogao -once -site tmtpost -type tag -proxy > itaogao-tmtpost-tag.out 2>&1 &

nohup sh run.sh itaogao -once -site tmtpost -type pagesize -proxy > itaogao-tmtpost-pagesize.out 2>&1 &

nohup sh run.sh itaogao -once -site tmtpost -type seed -proxy > itaogao-tmtpost-seed.out 2>&1 &

nohup sh run.sh itaogao -once -site tmtpost -type page -proxy > itaogao-tmtpost-page.out 2>&1 &

nohup sh run.sh itaogao -quartz -site tmtpost -type all -proxy > itaogao-tmtpost-all.out 2>&1 &
nohup sh run.sh itaogao -once -site tmtpost -type all -proxy > itaogao-tmtpost-all.out 2>&1 &


###############jingji21#################
##first run seed|page
#nohup sh run.sh itaogao -once -site jingji21 -type seed > itaogao-jingji21-seed.out 2>&1 &
#nohup sh run.sh itaogao -once -site jingji21 -type page -proxy > itaogao-jingji21-page.out 2>&1 &

nohup sh run.sh itaogao -quartz -site jingji21 -type update > itaogao-jingji21-update.out 2>&1 &
nohup sh run.sh itaogao -once -site jingji21 -type update> itaogao-jingji21-update.out 2>&1 &

###############southcn#################
## first run seed|page
#nohup sh run.sh itaogao -once -site southcn -type seed > itaogao-southcn-seed.out 2>&1 &
#nohup sh run.sh itaogao -once -site southcn -type page -proxy > itaogao-southcn-page.out 2>&1 &

nohup sh run.sh itaogao -quartz -site southcn -type update > itaogao-southcn-update.out 2>&1 &
nohup sh run.sh itaogao -once -site southcn -type update > itaogao-southcn-update.out 2>&1 &

###############cbcomcn#################
### dont default to run
#nohup sh run.sh itaogao -once -site cbcomcn -type seed > itaogao-cbcomcn-seed.out 2>&1 &
#nohup sh run.sh itaogao -once -site cbcomcn -type page -proxy > itaogao-cbcomcn-page.out 2>&1 &
#nohup sh run.sh itaogao -quartz -site cbcomcn -type update -proxy > itaogao-cbcomcn-update.out 2>&1 &
#nohup sh run.sh itaogao -once -site cbcomcn -type update -proxy > itaogao-cbcomcn-update.out 2>&1 &


############### mrjjxw #################
### dont default to run
#nohup sh run.sh itaogao -once -site mrjjxw -type seed > itaogao-mrjjxw-seed.out 2>&1 &
#nohup sh run.sh itaogao -once -site mrjjxw -type page -proxy > itaogao-mrjjxw-page.out 2>&1 &
nohup sh run.sh itaogao -quartz -site mrjjxw -type update -proxy > itaogao-mrjjxw-update.out 2>&1 &
nohup sh run.sh itaogao -once -site mrjjxw -type update -proxy > itaogao-mrjjxw-update.out 2>&1 &

############### yicai #################
nohup sh run.sh itaogao -once -site yicai -type all > itaogao-yicai-all.out 2>&1 &
nohup sh run.sh itaogao -quartz -site yicai -type update > itaogao-yicai-update.out 2>&1 &

############### caijing #################
nohup sh run.sh itaogao -once -site caijing -type all > itaogao-caijing-all.out 2>&1 &
nohup sh run.sh itaogao -quartz -site caijing -type update > itaogao-caijing-update.out 2>&1 &

############### bjbusiness #################
nohup sh run.sh itaogao -once -site bjbusiness -type all > itaogao-bjbusiness-all.out 2>&1 &
nohup sh run.sh itaogao -quartz -site bjbusiness -type update > itaogao-bjbusiness-update.out 2>&1 &

############### jjckb #################
nohup sh run.sh itaogao -once -site jjckb -type all > itaogao-jjckb-all.out 2>&1 &
nohup sh run.sh itaogao -quartz -site jjckb -type update > itaogao-jjckb-update.out 2>&1 &

