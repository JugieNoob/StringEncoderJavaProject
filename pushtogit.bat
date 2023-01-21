@echo off
git init
git add .
git pull --rebase origin main
set /p NameOfCommit=What what you like to name your commit?
git commit -m "%NameOfCommit%"
git remote set-url --add --push origin https://github.com/JugieNoob/StringEncoderJavaProject.git
git push -u origin origin main
echo "Committed to Github!"
echo "Press ENTER to close this window!"
set /p EnterToClose=