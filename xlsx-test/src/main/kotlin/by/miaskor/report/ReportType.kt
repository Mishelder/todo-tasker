package by.miaskor.report

enum class ReportType(
  val sheetName: String
) {

  PERSONAL_ACCOUNT("Лицевой счет"),
  TRANSACTIONS_ACCOUNT("Проводки"),
  INCOME_EXPENSES_ACCOUNT("Счета учета доходов-расходов"),
  CESSION_ACCOUNT("Счета учета цессии"),
  PAYMENT_AGENTS_ACCOUNT("Счета учета Платежных агентов"),
  CONTRACTOR_ACCOUNT("Контрагенты"),
  TURNOVER_STATEMENT_ACCOUNT_488("Отчет по счету 488"),
  CARD_ACCOUNT_488("Отчет по счету 488"),
  TURNOVER_STATEMENT_ACCOUNT_488_REFINANCE("Отчет по счету 488"),
  CARD_ACCOUNT_488_REFINANCE("Отчет по счету 488"),
  TURNOVER_STATEMENT_ACCOUNT_488_INSURANCE("Отчет по счету 488"),
  CARD_ACCOUNT_488_INSURANCE("Отчет по счету 488"),
  TURNOVER_STATEMENT_ACCOUNT_60322_PENALTY("Отчет по счету 60322, 60323"),
  TURNOVER_STATEMENT_ACCOUNT_60322_ACTION("Отчет по счету 60322, 60323"),
  TURNOVER_STATEMENT_ACCOUNT_61217_CESSION("Отчет по счету 61217"),
  CARD_ACCOUNT_61217_CESSION("Отчет по счету 61217"),
}
