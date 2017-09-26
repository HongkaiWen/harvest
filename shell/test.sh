#!/bin/bash 

REPOSITORY=/data/photo-center
STAGE=/data/harvest

mkdir -p $REPOSITORY
mkdir -p $STAGE

function scan(){
    for file in `ls $1`
    do
        if [ -d $1"/"$file ]  
        then
            scan $1"/"$file
        else
            move_file $1"/"$file || echo "file failed: "$1"/"$file
        fi
    done
}


function move_file(){
    # 读取exif信息
    PHOTO_TIME=`exiftool  $1 | grep "Date/Time Original" | head -1` || exit 1
    PHOTO_TIME=${PHOTO_TIME#*:}
    PHOTO_TIME=${PHOTO_TIME%.*}
    PHOTO_TIME=${PHOTO_TIME% *}
    
    
    if [ -z "$PHOTO_TIME" ]
    then
         return 2 
    fi


    # 拍摄月
    MONTH=${PHOTO_TIME:6:2}
    
    # 拍摄年
    YEAR=${PHOTO_TIME:1:4}

    # 目标路径
    TARGET_PATH=$REPOSITORY/$YEAR/$MONTH
    
    mkdir -p $TARGET_PATH

    # 移动照片
    cp -r $1 $TARGET_PATH
}


scan $STAGE
