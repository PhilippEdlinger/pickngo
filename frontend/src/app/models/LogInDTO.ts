import { User } from "./User";

export class LogInDTO {
    success: boolean;
    msgs: [String, String];
    person: User;

}