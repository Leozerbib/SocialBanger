export class SubscriptionPlus {
    id: number;
    userId: number;
    subscribedUserId: number;
    createdAt: Date;
  
    constructor(id: number, userId: number, subscribedUserId: number, createdAt: Date) {
      this.id = id;
      this.userId = userId;
      this.subscribedUserId = subscribedUserId;
      this.createdAt = createdAt;
    }
  }
  