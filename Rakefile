require 'rubygems'
require 'rake'

begin
  require 'jeweler'
  Jeweler::Tasks.new do |gem|
    gem.name = "cipango-jars"
    gem.summary = "Cipango and Jetty minimal dependencies"
    gem.description = "Cipango and Jetty minimal dependencies" 
    gem.email = "dominique.broeglin@gmail.com"
    gem.homepage = "http://github.com/dbroeglin/cipango-jars"
    gem.authors = ["Dominique Broeglin"]
    gem.files += Dir['lib/**/*.jar']
    # gem is a Gem::Specification... see http://www.rubygems.org/read/chapter/20 for additional settings
  end
  Jeweler::GemcutterTasks.new
rescue LoadError
  puts "Jeweler (or a dependency) not available. Install it with: gem install jeweler"
end

task :default => :build

require 'rake/rdoctask'
Rake::RDocTask.new do |rdoc|
  version = File.exist?('VERSION') ? File.read('VERSION') : ""

  rdoc.rdoc_dir = 'rdoc'
  rdoc.title = "cipango-jars #{version}"
  rdoc.rdoc_files.include('README*')
  rdoc.rdoc_files.include('lib/**/*.rb')
end

begin
  require 'ant'
  directory "pkg/classes"
  task :compile => "pkg/classes" do |t|
    ant.javac :srcdir => "ext", :destdir => t.prerequisites.first,
    :source => "1.5", :target => "1.5", :debug => true,
    :classpath => "${java.class.path}:${sun.boot.class.path}:" + Dir["lib/*.jar"].join(':')
  end

  task :jar => :compile do
    ant.jar :basedir => "pkg/classes", :destfile => "lib/cipango-main-1.0.jar", :includes => "**/*.class"
  end
rescue LoadError
  task :jar do
    puts "Run 'jar' with JRuby >= 1.5 to re-compile the java war booster"
  end
end

task :package => :jar
