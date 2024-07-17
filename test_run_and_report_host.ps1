# # Перейти в директорию проекта
# cd C:\Users\autotest\IdeaProjects\Efficiency_AutoTest
#
# # Выполнить очистку и тесты
# mvn clean test
#
# # Сгенерировать Allure отчет
# mvn allure:report
#
# # Остановить старый процесс Python-сервера
# $pythonProcesses = Get-Process -Name "python" -ErrorAction SilentlyContinue
# if ($pythonProcesses) {
#     foreach ($process in $pythonProcesses) {
#         # Проверьте, что процесс был запущен с аргументом http.server
#         $commandLine = (Get-WmiObject Win32_Process -Filter "ProcessId = $($process.Id)").CommandLine
#         if ($commandLine -like "*-m http.server 8085*") {
#             $process.Kill()
#         }
#     }
# }
#
# # Перейти в директорию с отчетом Allure
# cd target/allure-report
#
# # Запустить локальный сервер на Python для предоставления отчета в фоновом режиме
# Start-Process -NoNewWindow -FilePath "python" -ArgumentList "-m http.server 8085"
#
# # Сообщение о запуске сервера
# Write-Output "Локальный сервер запущен"
#
#
#
#

# Перейти в директорию проекта
cd C:\Users\autotest\IdeaProjects\Efficiency_AutoTest

# Выполнить очистку и тесты
mvn clean test

# Сгенерировать Allure отчет
mvn allure:report

# Определение путей для копирования отчета
$sourcePath = "C:\Users\autotest\IdeaProjects\Efficiency_AutoTest\target\allure-report"
$destinationPath = "C:\Users\autotest\IdeaProjects\Efficiency_AutoTest\hosted-allure-report"

# Удалить содержимое старого отчета, но не саму директорию
Get-ChildItem -Path $destinationPath -Recurse -Force | Remove-Item -Recurse -Force

# Копировать новый отчет
Copy-Item -Recurse -Force $sourcePath\* $destinationPath


