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
  TURNOVER_STATEMENT_ACCOUNT_488("Оборотно-сальдовая ведомость по счетам 488"),
  TURNOVER_STATEMENT_ACCOUNT_488_REFINANCE("Оборотно-сальдовая ведомость по счетам 488 (РЕФИНАНСИРОВАНИЕ)"),
  TURNOVER_STATEMENT_ACCOUNT_488_INSURANCE("Оборотно-сальдовая ведомость по счетам 488 за Июль 2021 г. (СТРАХОВАНИЕ)"),
  TURNOVER_STATEMENT_ACCOUNT_60322_PENALTY("Оборотно-сальдовая ведомость по счетам 60322 (ПЕНИ)"),
  TURNOVER_STATEMENT_ACCOUNT_60322_ACTION("Оборотно-сальдовая ведомость по счетам 60323 (АКЦИЯ)"),
  TURNOVER_STATEMENT_ACCOUNT_61217_CESSION("Оборотно-сальдовая ведомость по счетам 61217 (ЦЕССИЯ)"),
  CARD_ACCOUNT_488("Карточка счета 488"),
  CARD_ACCOUNT_488_REFINANCE("Карточка счета 488 (РЕФИНАНСИРОВАНИЕ)"),
  CARD_ACCOUNT_488_INSURANCE("Карточка счета 48801 (СТРАХОВАНИЕ)"),
  CARD_ACCOUNT_61217_CESSION("Карточка счета 61217 (ЦЕССИЯ)"),
}
