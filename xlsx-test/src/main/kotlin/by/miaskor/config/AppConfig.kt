package by.miaskor.config

import by.miaskor.generator.ExcelGenerator
import by.miaskor.report.CardAccountCessionReport
import by.miaskor.report.CardAccountInsuranceReport
import by.miaskor.report.CardAccountRefinanceReport
import by.miaskor.report.CardAccountReport
import by.miaskor.report.CessionAccountReport
import by.miaskor.report.CompositeReport
import by.miaskor.report.ContractorAccountReport
import by.miaskor.report.IncomeExpensesAccountReport
import by.miaskor.report.PaymentAgentsAccountReport
import by.miaskor.report.PersonalAccountReport
import by.miaskor.report.TransactionsAccountReport
import by.miaskor.report.TurnOverStatementAccountActionReport
import by.miaskor.report.TurnOverStatementAccountCessionReport
import by.miaskor.report.TurnOverStatementAccountInsuranceReport
import by.miaskor.report.TurnOverStatementAccountPenaltyReport
import by.miaskor.report.TurnOverStatementAccountRefinanceReport
import by.miaskor.report.TurnOverStatementAccountReport
import by.miaskor.style.DefaultStyleCreator
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class AppConfig(
  private val excelGenerator: ExcelGenerator,
  private val workbook: XSSFWorkbook
) {

  @Bean
  open fun compositeReport(): CompositeReport {
    return CompositeReport(
      cardAccountCessionReport(),
      cardAccountInsuranceReport(),
      cardAccountRefinanceReport(),
      cardAccountReport(),
      cessionAccountReport(),
      contractorAccountReport(),
      incomeExpensesAccountReport(),
      paymentAgentsAccountReport(),
      paymentAgentsAccountReport(),
      personalAccountReport(),
      transactionsAccountReport(),
      turnOverStatementAccountActionReport(),
      turnOverStatementAccountCessionReport(),
      turnOverStatementAccountInsuranceReport(),
      turnOverStatementAccountPenaltyReport(),
      turnOverStatementAccountRefinanceReport(),
      transactionsAccountReport()
    )
  }

  @Bean
  open fun defaultStyleCreator(): DefaultStyleCreator {
    return DefaultStyleCreator()
  }

  @Bean
  open fun cardAccountCessionReport(): CardAccountCessionReport {
    return CardAccountCessionReport(excelGenerator, defaultStyleCreator(), workbook)
  }

  @Bean
  open fun cardAccountInsuranceReport(): CardAccountInsuranceReport {
    return CardAccountInsuranceReport(excelGenerator, defaultStyleCreator(), workbook)
  }

  @Bean
  open fun cardAccountRefinanceReport(): CardAccountRefinanceReport {
    return CardAccountRefinanceReport(excelGenerator, defaultStyleCreator(), workbook)
  }

  @Bean
  open fun cardAccountReport(): CardAccountReport {
    return CardAccountReport(excelGenerator, defaultStyleCreator(), workbook)
  }

  @Bean
  open fun cessionAccountReport(): CessionAccountReport {
    return CessionAccountReport(excelGenerator, defaultStyleCreator(), workbook)
  }

  @Bean
  open fun contractorAccountReport(): ContractorAccountReport {
    return ContractorAccountReport(excelGenerator, defaultStyleCreator(), workbook)
  }

  @Bean
  open fun incomeExpensesAccountReport(): IncomeExpensesAccountReport {
    return IncomeExpensesAccountReport(excelGenerator, defaultStyleCreator(), workbook)
  }

  @Bean
  open fun personalAccountReport(): PersonalAccountReport {
    return PersonalAccountReport(excelGenerator, defaultStyleCreator(), workbook)
  }

  @Bean
  open fun paymentAgentsAccountReport(): PaymentAgentsAccountReport {
    return PaymentAgentsAccountReport(excelGenerator, defaultStyleCreator(), workbook)
  }

  @Bean
  open fun transactionsAccountReport(): TransactionsAccountReport {
    return TransactionsAccountReport(excelGenerator, defaultStyleCreator(), workbook)
  }

  @Bean
  open fun turnOverStatementAccountActionReport(): TurnOverStatementAccountActionReport {
    return TurnOverStatementAccountActionReport(excelGenerator, defaultStyleCreator(), workbook)
  }

  @Bean
  open fun turnOverStatementAccountCessionReport(): TurnOverStatementAccountCessionReport {
    return TurnOverStatementAccountCessionReport(excelGenerator, defaultStyleCreator(), workbook)
  }

  @Bean
  open fun turnOverStatementAccountInsuranceReport(): TurnOverStatementAccountInsuranceReport {
    return TurnOverStatementAccountInsuranceReport(excelGenerator, defaultStyleCreator(), workbook)
  }

  @Bean
  open fun turnOverStatementAccountPenaltyReport(): TurnOverStatementAccountPenaltyReport {
    return TurnOverStatementAccountPenaltyReport(excelGenerator, defaultStyleCreator(), workbook)
  }

  @Bean
  open fun turnOverStatementAccountRefinanceReport(): TurnOverStatementAccountRefinanceReport {
    return TurnOverStatementAccountRefinanceReport(excelGenerator, defaultStyleCreator(), workbook)
  }

  @Bean
  open fun turnOverStatementAccountReport(): TurnOverStatementAccountReport {
    return TurnOverStatementAccountReport(excelGenerator, defaultStyleCreator(), workbook)
  }
}
