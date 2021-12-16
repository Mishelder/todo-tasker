function createDivForExistTask(date, item) {
  const tasksDiv = document.getElementById(date).getElementsByClassName(
          'tasks')[0],
      taskDiv = new Div(item['id'], 'task'),
      taskValueDiv = new Div('', 'value_task'),
      task = new InputElement('text', '', item['taskName'], '', '', false,
          '');
  taskDiv.renderAppend(tasksDiv);
  if (item['taskName'].length > MIN_LENGTH_FOR_TEXT_AREA) {
    isMatchedValueForTextArea(task.inputElement.value, taskDiv.divElement);
  }
  taskValueDiv.renderAppend(taskDiv.divElement);
  task.renderAppend(taskValueDiv.divElement);
  task.inputElement.disabled = true;
  if (item['done'] === true) {
    task.inputElement.classList.add('is_done');
  }
  changeDoneStatusOnClick(taskValueDiv.divElement, task.inputElement,
      taskDiv.divElement);
  createAlternationDiv(taskDiv.divElement);
}

function createAlternationDiv(taskDiv) {
  const alternationDiv = new Div('', 'alternation_task', 'hidden'),
      deleteImage = document.createElement('img'),
      alternateImage = document.createElement('img'),
      divForDeleteImage = new Div('', 'delete_image'),
      divForAlternateImage = new Div('', 'alternate_image');
  alternationDiv.renderAppend(taskDiv);
  divForDeleteImage.renderAppend(taskDiv);
  divForAlternateImage.renderAppend(taskDiv);
  deleteImage.src = '../img/recycle.png';
  alternateImage.src = '../img/pencil.png';
  divForDeleteImage.divElement.addEventListener('click', () => {
    taskDiv.remove();
    deleteTask(taskDiv.id);
  });
  divForAlternateImage.divElement.addEventListener('click', () => {
    const value_task = taskDiv.getElementsByClassName('value_task')[0],
        input = value_task.getElementsByTagName('input')[0],
        divText = taskDiv.getElementsByClassName("pop_up_task")[0];
    if (divText !== undefined) {
      divText.classList.remove("pop_up_task");
    }

    input.disabled = false;
    input.focus();
    input.onblur = () => {
      whenAlternationIsEnd();
    };
    input.addEventListener('keydown', (event) => {
      if (event.key === "Enter") {
        whenAlternationIsEnd();
      }
    });

    function whenAlternationIsEnd() {
      if (input.value.length === 0) {
        taskDiv.remove();
        deleteTask(taskDiv.id);
      } else {
        input.disabled = true;
        if (input.value.length < MIN_LENGTH_FOR_TEXT_AREA) {
          if (divText !== undefined) {
            divText.remove();
          }
        } else {
          if (divText !== undefined) {
            divText.innerText = input.value;
            divText.classList.add("pop_up_task");
          } else {
            isMatchedValueForTextArea(input.value, taskDiv);
          }
        }
        const toDoDay = taskDiv.parentElement.parentElement;
        updateTask(taskDiv.id, input.value,
            input.classList.contains('is_done'), toDoDay.id);
      }
    }
  });
  divForAlternateImage.divElement.append(alternateImage);
  divForDeleteImage.divElement.append(deleteImage);
  alternationDiv.divElement.append(divForDeleteImage.divElement);
  alternationDiv.divElement.append(divForAlternateImage.divElement);
  taskDiv.append(alternationDiv.divElement);
}

function createDivForTask(date) {
  const tasksDiv = document.getElementById(date).getElementsByClassName(
          'tasks')[0],
      taskDiv = new Div('', 'task'),
      taskValueDiv = new Div('', 'value_task'),
      task = new InputElement('text', '', '', '', '', false, '');
  taskDiv.renderAppend(tasksDiv);
  taskValueDiv.renderAppend(taskDiv.divElement);
  task.renderAppend(taskValueDiv.divElement);
  changeDoneStatusOnClick(taskValueDiv.divElement, task.inputElement,
      taskDiv.divElement);
  task.inputElement.onblur = () => {
    isMatchedValueForTextArea(task.inputElement.value, taskDiv.divElement);
    save();
  };

  task.inputElement.addEventListener('keydown', saveWhenPressEnter);
  task.inputElement.focus();

  function save() {
    if (task.inputElement.value.length !== 0) {
      task.inputElement.onblur = () => {
      };
      task.inputElement.disabled = true;
      saveTask(date, task.inputElement.value, taskDiv.divElement)

      task.inputElement.removeEventListener('keydown',
          saveWhenPressEnter);
    }
  }

  function saveWhenPressEnter(event) {
    if (event.key === "Enter") {
      isMatchedValueForTextArea(task.inputElement.value,
          taskDiv.divElement);
      save();
    }
  }
}

function isMatchedValueForTextArea(value, taskDiv) {
  if (value.length > MIN_LENGTH_FOR_TEXT_AREA && value.length < 512) {
    let divAreaElem = new Div("", "hidden", "pop_up_task");
    divAreaElem.renderAppend(taskDiv);
    divAreaElem.divElement.innerText = value;
  }
}

function createTask(date) {
  let tasksValue = null;
  if (allTasks.hasOwnProperty(date)) {
    tasksValue = allTasks[date].sort(function (a, b) {
      if (a.id > b.id) {
        return 1
      }
      if (a.id < b.id) {
        return -1
      }
      return 0
    });
    for (let index = 0; index < tasksValue.length; index++) {
      createDivForExistTask(date, tasksValue[index]);
    }
    createDivForTask(date);
  } else {
    createDivForTask(date);
  }
}
