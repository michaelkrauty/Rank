cd C:\Users\Michael\Desktop\test_server
rmdir /Q /S git\Rank\src
rmdir /Q /S git\Rank\target
mkdir git\Rank\src
mkdir git\Rank\target
copy plugins\Rank.jar git\Rank\src
cd git\Rank\src
jar xf Rank.jar
rmdir /Q /S META-INF
del .project
del .classpath
move Rank.jar ../target
cd me\michaelkrauty\Rank
del *.class
del commands\*.class
cd ../../../../
git add --all
git commit -m update
git push