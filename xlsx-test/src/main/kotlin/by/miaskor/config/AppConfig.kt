package by.miaskor.config

import by.miaskor.report.CardAccountCessionReport
import by.miaskor.report.CardAccountInsuranceReport
import by.miaskor.report.CardAccountRefinanceReport
import by.miaskor.report.CardAccountReport
import by.miaskor.report.CessionAccountReport
import by.miaskor.report.ContractorAccountReport
import by.miaskor.report.IncomeExpensesAccountReport
import by.miaskor.report.PaymentAgentsAccountReport
import by.miaskor.report.PersonalAccountReport
import by.miaskor.report.ReportRegistry
import by.miaskor.report.TransactionsAccountReport
import by.miaskor.report.TurnOverStatementAccountActionReport
import by.miaskor.report.TurnOverStatementAccountCessionReport
import by.miaskor.report.TurnOverStatementAccountInsuranceReport
import by.miaskor.report.TurnOverStatementAccountPenaltyReport
import by.miaskor.report.TurnOverStatementAccountRefinanceReport
import by.miaskor.report.TurnOverStatementAccountReport
import by.miaskor.service.ReportService
import by.miaskor.style.DefaultStyleCreator
import by.miaskor.style.sheet.CalculationAnalyticalAccountingSheetAdjuster
import by.miaskor.style.sheet.CardAccountSheetAdjuster
import by.miaskor.style.sheet.ContractorPersonalAccountSheetAdjuster
import by.miaskor.style.sheet.IncomeAnalyticalAccountingSheetAdjuster
import by.miaskor.style.sheet.PersonalAccountSheetAdjuster
import by.miaskor.style.sheet.StatementPersonalAccountSheetAdjuster
import by.miaskor.style.sheet.TurnOverStatementSheetAdjuster
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class AppConfig {

  @Bean
  open fun reportService(): ReportService {
    return ReportService(reportRegistry())
  }

  @Bean
  open fun styleCreator(): DefaultStyleCreator {
    return DefaultStyleCreator()
  }

  @Bean
  open fun personalAccountSheetAdjuster(): PersonalAccountSheetAdjuster {
    return PersonalAccountSheetAdjuster()
  }

  @Bean
  open fun calculationAnalyticalAccountingSheetAdjuster(): CalculationAnalyticalAccountingSheetAdjuster {
    return CalculationAnalyticalAccountingSheetAdjuster()
  }

  @Bean
  open fun cardAccountSheetAdjuster(): CardAccountSheetAdjuster {
    return CardAccountSheetAdjuster()
  }

  @Bean
  open fun contractorPersonalAccountSheetAdjuster(): ContractorPersonalAccountSheetAdjuster {
    return ContractorPersonalAccountSheetAdjuster()
  }

  @Bean
  open fun incomeAnalyticalAccountingSheetAdjuster(): IncomeAnalyticalAccountingSheetAdjuster {
    return IncomeAnalyticalAccountingSheetAdjuster()
  }

  @Bean
  open fun statementPersonalAccountSheetAdjuster(): StatementPersonalAccountSheetAdjuster {
    return StatementPersonalAccountSheetAdjuster()
  }

  @Bean
  open fun turnOverStatementSheetAdjuster(): TurnOverStatementSheetAdjuster {
    return TurnOverStatementSheetAdjuster()
  }

  @Bean
  open fun reportRegistry(): ReportRegistry {
    return ReportRegistry(
      listOf(
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
        turnOverStatementAccountReport(),
        transactionsAccountReport()
      ).associateBy { it.typeReport() }
    )
  }

  @Bean
  open fun defaultStyleCreator(): DefaultStyleCreator {
    return DefaultStyleCreator()
  }

  @Bean
  open fun cardAccountCessionReport(): CardAccountCessionReport {
    return CardAccountCessionReport(
      styleCreator(),
      cardAccountSheetAdjuster()
    )
  }

  @Bean
  open fun cardAccountInsuranceReport(): CardAccountInsuranceReport {
    return CardAccountInsuranceReport(
      styleCreator(),
      cardAccountSheetAdjuster()
    )
  }

  @Bean
  open fun cardAccountRefinanceReport(): CardAccountRefinanceReport {
    return CardAccountRefinanceReport(
      styleCreator(),
      cardAccountSheetAdjuster()
    )
  }

  @Bean
  open fun cardAccountReport(): CardAccountReport {
    return CardAccountReport(
      styleCreator(),
      cardAccountSheetAdjuster()
    )
  }

  @Bean
  open fun cessionAccountReport(): CessionAccountReport {
    return CessionAccountReport(
      styleCreator(),
      calculationAnalyticalAccountingSheetAdjuster()
    )
  }

  @Bean
  open fun contractorAccountReport(): ContractorAccountReport {
    return ContractorAccountReport(
      styleCreator(),
      contractorPersonalAccountSheetAdjuster()
    )
  }

  @Bean
  open fun incomeExpensesAccountReport(): IncomeExpensesAccountReport {
    return IncomeExpensesAccountReport(
      styleCreator(),
      incomeAnalyticalAccountingSheetAdjuster()
    )
  }

  @Bean
  open fun personalAccountReport(): PersonalAccountReport {
    return PersonalAccountReport(
      styleCreator(),
      personalAccountSheetAdjuster()
    )
  }

  @Bean
  open fun paymentAgentsAccountReport(): PaymentAgentsAccountReport {
    return PaymentAgentsAccountReport(
      styleCreator(),
      calculationAnalyticalAccountingSheetAdjuster()
    )
  }

  @Bean
  open fun transactionsAccountReport(): TransactionsAccountReport {
    return TransactionsAccountReport(
      styleCreator(),
      statementPersonalAccountSheetAdjuster()
    )
  }

  @Bean
  open fun turnOverStatementAccountActionReport(): TurnOverStatementAccountActionReport {
    return TurnOverStatementAccountActionReport(
      styleCreator(),
      turnOverStatementSheetAdjuster()
    )
  }

  @Bean
  open fun turnOverStatementAccountCessionReport(): TurnOverStatementAccountCessionReport {
    return TurnOverStatementAccountCessionReport(
      styleCreator(),
      turnOverStatementSheetAdjuster()
    )
  }

  @Bean
  open fun turnOverStatementAccountInsuranceReport(): TurnOverStatementAccountInsuranceReport {
    return TurnOverStatementAccountInsuranceReport(
      styleCreator(),
      turnOverStatementSheetAdjuster()
    )
  }

  @Bean
  open fun turnOverStatementAccountPenaltyReport(): TurnOverStatementAccountPenaltyReport {
    return TurnOverStatementAccountPenaltyReport(
      styleCreator(),
      turnOverStatementSheetAdjuster()
    )
  }

  @Bean
  open fun turnOverStatementAccountRefinanceReport(): TurnOverStatementAccountRefinanceReport {
    return TurnOverStatementAccountRefinanceReport(
      styleCreator(),
      turnOverStatementSheetAdjuster()
    )
  }

  @Bean
  open fun turnOverStatementAccountReport(): TurnOverStatementAccountReport {
    return TurnOverStatementAccountReport(
      styleCreator(),
      turnOverStatementSheetAdjuster()
    )
  }
}
