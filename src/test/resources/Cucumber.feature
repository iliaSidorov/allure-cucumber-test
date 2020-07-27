#language: ru

Функционал: Оформление ипотеки

  @all
  @checkCredit
  Сценарий: Заявка на ипотеку
    Когда выбрано меню "Ипотека"
    И выбран вид ипотеки "Ипотека на готовое жильё"
    И осуществлен переход к форме заявки

    Когда заполняются поля:
      | Стоимость недвижимости | 5180000 |
      | Первоначальный взнос   | 3058000 |
      | Срок кредита          | 30      |

    Когда деактивирован чекбокс Страхование жизни
    И активирован чекбокс Молодая семья

    Тогда значения полей равны:
      | Ежемесячный платеж | 16922    |
      | Сумма кредита      | 2122000 |
      | Процентная ставка  | 11%      |

