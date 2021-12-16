function isNeededZero(date) {
  if (date > 0 && date < 10) {
    return '0' + date;
  }
  return date;
}
