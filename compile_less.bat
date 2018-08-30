SET LESS_FILE=src\main\resources\static\less\base.less
SET CSS_FILE=src\main\resources\static\css\base.css

lessc %LESS_FILE% --clean-css %CSS_FILE%
