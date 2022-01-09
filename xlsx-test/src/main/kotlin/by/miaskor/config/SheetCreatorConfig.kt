package by.miaskor.config

import by.miaskor.generator.ExcelGenerator
import by.miaskor.generator.ExcelToPdfConverter
import by.miaskor.style.sheet.AccountFEESheetModifier
import by.miaskor.style.sheet.AccountSOTOSSheetModifier
import by.miaskor.style.sheet.AccountSZTTTSheetModifier
import by.miaskor.style.sheet.CessionAccountSheetModifier
import by.miaskor.style.sheet.CompositeSheetModifier
import by.miaskor.style.sheet.ContractorAccountSheetModifier
import by.miaskor.style.sheet.IncomeExpensesAccountSheetModifier
import by.miaskor.style.sheet.PaymentAgentsSheetModifier
import by.miaskor.style.sheet.PersonalAccountSheetModifier
import by.miaskor.style.sheet.TransactionsSheetModifier
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class SheetCreatorConfig {

  @Bean
  open fun workBook(): XSSFWorkbook {
    return XSSFWorkbook()
  }

  @Bean
  open fun excelGenerator(): ExcelGenerator {
    return ExcelGenerator(compositeSheetCreator(), workBook())
  }

  @Bean
  open fun pdfGenerator(): ExcelToPdfConverter {
    return ExcelToPdfConverter(workBook())
  }

  @Bean
  open fun accountFEESheetCreator(): AccountFEESheetModifier {
    return AccountFEESheetModifier()
  }

  @Bean
  open fun accountSOTOSSheetCreator(): AccountSOTOSSheetModifier {
    return AccountSOTOSSheetModifier()
  }

  @Bean
  open fun accountSZTTTSheetCreator(): AccountSZTTTSheetModifier {
    return AccountSZTTTSheetModifier()
  }

  @Bean
  open fun cessionAccountSheetCreator(): CessionAccountSheetModifier {
    return CessionAccountSheetModifier()
  }

  @Bean
  open fun contractorAccountSheetCreator(): ContractorAccountSheetModifier {
    return ContractorAccountSheetModifier()
  }

  @Bean
  open fun incomeExpensesAccountSheetCreator(): IncomeExpensesAccountSheetModifier {
    return IncomeExpensesAccountSheetModifier()
  }

  @Bean
  open fun paymentAgentsSheetCreator(): PaymentAgentsSheetModifier {
    return PaymentAgentsSheetModifier()
  }

  @Bean
  open fun personalAccountSheetCreator(): PersonalAccountSheetModifier {
    return PersonalAccountSheetModifier()
  }

  @Bean
  open fun transactionsSheetCreator(): TransactionsSheetModifier {
    return TransactionsSheetModifier()
  }

  @Bean
  open fun compositeSheetCreator(): CompositeSheetModifier {
    return CompositeSheetModifier(
      listOf(
        accountFEESheetCreator(),
        accountSOTOSSheetCreator(),
        accountSZTTTSheetCreator(),
        cessionAccountSheetCreator(),
        contractorAccountSheetCreator(),
        incomeExpensesAccountSheetCreator(),
        transactionsSheetCreator(),
        paymentAgentsSheetCreator(),
        personalAccountSheetCreator()
      ).associateBy { it.sheetName() }
    )
  }
}
