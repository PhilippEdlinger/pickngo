import { User } from "./User";

export interface LogInDTO {
    success: boolean;
    msgs: [String, String];
    person: User;
}