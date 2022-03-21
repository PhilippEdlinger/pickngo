export class Todolist {

  id: number;
  title: string;
  completed = false;
  dueDate = new Date();

  constructor(values: any = {}) {
    Object.assign(this, values);
  }

}
