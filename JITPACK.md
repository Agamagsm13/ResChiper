# Публикация через JitPack.io

## Шаги для публикации:

### 1. Убедитесь, что проект на GitHub
- Репозиторий должен быть публичным: `https://github.com/agamagsm13/reschiper`

### 2. Создайте тег/релиз на GitHub
```bash
# Создайте тег для версии
git tag 0.1.6-rc6
git push origin 0.1.6-rc6

# Или создайте релиз через GitHub UI:
# 1. Перейдите в раздел Releases
# 2. Нажмите "Draft a new release"
# 3. Укажите версию (например, v0.1.2-rc6)
# 4. Опубликуйте релиз
```

### 3. JitPack автоматически соберет проект
- Перейдите на https://jitpack.io
- Введите: `agamagsm13/reschiper`
- JitPack автоматически найдет ваш репозиторий и начнет сборку

### 4. Использование в других проектах

Добавьте в `build.gradle`:

```gradle
buildscript {
  repositories {
    maven { url 'https://jitpack.io' }
    mavenCentral()
    google()
  }
  
  dependencies {
    // Формат: com.github.USERNAME:REPO:VERSION:artifact
    classpath "com.github.agamagsm13:reschiper:0.1.2-rc6:plugin"
  }
}
```

### 5. Применить плагин

```gradle
apply plugin: "io.github.agamagsm13.reschiper"
```

## Важные замечания:

- JitPack использует файл `jitpack.yml` для настройки сборки
- Убедитесь, что версия в `build.gradle.kts` совпадает с тегом на GitHub
- Первая сборка может занять несколько минут
- Проверьте статус сборки на https://jitpack.io/#agamagsm13/reschiper

## Альтернативный формат (если стандартный не работает):

Если формат `com.github.agamagsm13:reschiper:VERSION:plugin` не работает, попробуйте:

```gradle
classpath "io.github.agamagsm13.reschiper:plugin:0.1.2-rc6"
```

И добавьте в repositories:
```gradle
maven { 
  url 'https://jitpack.io' 
  content {
    includeGroup "io.github.agamagsm13.reschiper"
  }
}
```

