
# Crypto.com Android interview demo project

This is a coding test for Android candidates for Crypto.com Shenzhen Team. This Demo project is a tiny taste of what you'll be working on if you join us.

Before proceeding to the section of your choice, please consider the following tips.

## General Advice and Tips

- Error scenarios，e.g. edge case/conner case, should be taken into consideration, even if you don't explicitly handle them.
- Although UI and UX are important, we are more concerned in this demo with your thought process and with how you architect your application. Your demo should take into consideration features that might be added in the future.
- Clean the file project structure and remove any unused methods. This shows attention to detail.
- Be opinionated regarding any architecture you use and take your time to make it a reflection of your thought process.

## The project

You will implement a simple Wallet Dashboard.

- The Wallet app should support the following currencies: BTC, ETH, and CRO.
- Data Source: three JSON are provided as data sources
- (1) [Supported Currencies](json/currencies-json.md)
- (2) [exchange rate for each currency to US Dollars](json/live-rates-json.md). For instance, if the user has 0.0026 BTC, and the live rate from BTC to USD is 9194.9300000000, then the USD balance for the currency is 0.0026 \* 9194.9300000000 = 23.906818 USD
- (3) [Wallet Balance for each currencies](json/wallet-balance-json.md)




-钱包应用程序应支持以下货币：BTC、ETH和CRO。
-数据源：提供三个JSON作为数据源
-（1）[支持的货币]（json/crencies json.md）
-（2）[每种货币对美元的汇率]（json/live-rates json.md）。例如，如果用户有0.0026 BTC，BTC到美元的实时汇率为9194.93亿美元，那么该货币的美元余额为0.0026 \*9194.93万亿=23.906818美元
-（3）[每种货币的钱包余额]（json/钱包余额json.md）
###要求
应满足以下要求：
-使用Kotlin。
-它应该编译并运行。
-您必须使用响应式编程。我们建议使用协程流。
-您必须在Github中为此项目创建一个私有仓库，并在git commits中持续向仓库提交代码。完成后，请将仓库的链接发送给我们。
-你应该在三天内完成这项工作。

### Requirements

The following requirements should be met:

- Use Kotlin.
- It should compile and run.
- You must use reactive programming. We recommend using Coroutine flow.
- You must create a private repo in Github for this project，and commit your code to the repo continuously in git commits. Send us the link to the repo when you are done.
- You should finish this in 3 days.

### Thanks for your time!