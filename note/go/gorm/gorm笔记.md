- 创建数据库连接

  ```go
  import (
  	"github.com/jinzhu/gorm"
  	_ "github.com/jinzhu/gorm/dialects/mysql"
  )
  
  func main() {
  	db, err := gorm.Open("mysql", "root:9999@/test?charset=utf8&parseTime=True&loc=Local")
  	defer db.Close()
  }
  ```

- 数据表

- ```go
  db.HasTable("users")
  db.HasTable(&User{})
  
  db.CreateTable(&User{})
  db.Set("gorm:table_options", "ENGINE=InnoDB").CreateTable(&User{})
  
  db.DropTable(&User{})
  db.DropTable("users")
  db.DropTableIfExists(&User{}, "products")
  ```

- 数据模型

- ```go
  gorm.Model{
      ID			int	`gorm:"column:id"`//设置列名映射
      CreatedAt	time.Time
      UpdatedAt	time.Time
      DeletedAt	time.Time
  }
  
  //设置表名
  func (Model) TableName() string {
    return "profiles"
  }
  
  //一对多
  db.Model(&user).Related(&emails)
  //多对多
  db.Model(&user).Related(&languages, "Languages")
  ```

- 约束

- ```go
  `gorm:"ForeignKey:ProfileRefer"`		//指定外键
  `gorm:"ForeignKey:ProfileID;AssociationForeignKey:Refer"`	//指定外键和关联外键
  `gorm:"many2many:user_languages;"`	//多对多
  `gorm:"default:'galeone'"`			//设置默认值
  ```

- 数据增删改查

- ```go
  db.Create(&user)
  
  
  db.First(&user)
  db.Last(&user)
  db.Find(&users)
  db.First(&user, 10)	//主键
  
  db.Where("name = ?", "jinzhu").First(&user)
  <>?
  in(?)
  LIKE ?
  AND 
  BETWEEN AND
  
  
  db.Where(&User{Name: "jinzhu", Age: 20}).First(&user)
  db.Not("name", "jinzhu").First(&user)
  db.Find(&user, "name = ?", "jinzhu")
  db.Where("role = ?", "admin").Or("role = ?", "super_admin").Find(&users)
  
  db.Where("role = ?", "admin").Or("role = ?", "super_admin").Not("name = ?", "jinzhu").Find(&users)	//拼接
  
  db.Select("name, age").Find(&users)
  db.Table("users").Select("COALESCE(age,?)", 42).Rows()
  db.Order("age desc, name").Find(&users)
  db.Limit(3).Find(&users)
  db.Offset(3).Find(&users)
  
  db.Where("name = ?", "jinzhu").Or("name = ?", "jinzhu 2").Find(&users).Count(&count)
  
  rows, err := db.Table("orders").Select("date(created_at) as date, sum(amount) as total").Group("date(created_at)").Having("sum(amount) > ?", 100).Rows()
  
  
  db.Save(&user)
  db.Model(&user).Where("active = ?", true).Update("name", "hello")
  
  db.Delete(&email)
  db.Where("email LIKE ?", "%jinzhu%").Delete(Email{})
  ```

- 回调

  ```go
  func (user *User) BeforeCreate(scope *gorm.Scope) error {
    scope.SetColumn("ID", uuid.New())
    return nil
  }
  ```

- 