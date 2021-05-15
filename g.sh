#!/bin/bash

time2=$(date "+%Y%m%d%H%M%S")

git add --all
git commit -m "$time2"
git push
