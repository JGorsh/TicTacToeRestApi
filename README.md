TicTacToeRestApi (SpringBoot, H2)

Реализовано: игра| возможность продолжить игру, которую не доиграли| из базы данных получение списков игр, 
игроков, игрока по id| воспроизведения игр из JSON файла| сохранение игры в XML, JSON формате| 
 

  - "/gameplay" (POST)-- Создание новой игры 
  
  - "/gameplay/{id}" (GET)-- Возвращает прогресс игры в JSON по id
  
  - "/gameplay/player/{playerName}" (GET)-- Создаем нового игрока в текущей игре
  
  - "/gameplay/players/{id}" (GET)-- Возвращает игрока по Id
  
  - "/gameplay/players" (GET)-- Возвращает список всех игроков
  
  - "/gameplay/game" (GET)-- Отображает поле текущей игры 
  
  - "/gameplay/game/{currentPlayerId}/{position}" (GET) -- для начала игры введите в адрес {currentPlayer} - имя игрока делающего ход, {position} выберите позицию
  
  - "/gameplay/init" (POST) -- для сброса игры
  
  - "/gameplay/{id}/continue" (GET) -- возвращение игры по id (последний ход), можно продолжить играть, если нет результата
  
  - "/gameplay/archive" (POST) -- в body Json с архивом игры, в ответе история игры и результат
  
  1) ДЛЯ ИГРЫ НУЖНО СОЗДАТЬ ИГРУ "/gameplay", СОЗДАЕМ ИГРОКОВ "/gameplay/player/{playerName}", 
  ИГРАЕМ "/gameplay/game/{currentPlayerId}/{position}"
  
  2) ДЛЯ СОЗДАНИЯ НОВОЙ ИГРЫ ПОСЛЕ ПРЕДЫДУЩЕЙ НУЖНО СБРОСИТЬ "/gameplay/init", ПОСЛЕ ПОВТОРИТЬ ПУНКТ 1)
  
Обработаны исключения: 
  - неверный символ ввода позиции или id, нельзя сделать ход, который был
  - неверные id
  - неверный JSON в body для воспроизведения игры
  - если есть результат игры нельзя продолжить делать ходы в текущей игре
  - нельзя создать больше 2х игроков в текущей игре
